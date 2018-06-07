package otc.open.com.otc.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.net.Uri;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import com.facebook.common.util.ByteConstants;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.backends.okhttp3.OkHttpImagePipelineConfigFactory;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.util.concurrent.atomic.AtomicInteger;

import okhttp3.OkHttpClient;

/**
 * <p>
 * Created by rexy on 2018/1/29.
 *
 * @date: 2015-11-16 13:04
 */
public class ImageDisplay {

    public static int REQUEST_LEVEL_FULL = 1;
    public static int REQUEST_LEVEL_MEMORY = 2;

    public static void initialize(Context context, OkHttpClient okHttpClient) {
        int MAX_DISK_CACHE_SIZE = 40 * ByteConstants.MB;
        int MAX_MEMORY_CACHE_SIZE = (int) Runtime.getRuntime().maxMemory() / 4;

        String IMAGE_PIPELINE_CACHE_DIR = "fresco_cache";

        final MemoryCacheParams bitmapCacheParams = new MemoryCacheParams(
                MAX_MEMORY_CACHE_SIZE, // Max total size of elements in the cache
                Integer.MAX_VALUE,                     // Max entries in the cache
                MAX_MEMORY_CACHE_SIZE, // Max total size of elements in eviction queue
                Integer.MAX_VALUE,                     // Max length of eviction queue
                Integer.MAX_VALUE);                    // Max cache entry size

        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient();
        }

        ImagePipelineConfig config = OkHttpImagePipelineConfigFactory
                .newBuilder(context, okHttpClient).setBitmapMemoryCacheParamsSupplier(
                        new Supplier<MemoryCacheParams>() {
                            @Override
                            public MemoryCacheParams get() {
                                return bitmapCacheParams;
                            }
                        })
                .setMainDiskCacheConfig(
                        DiskCacheConfig.newBuilder(context)
                                .setBaseDirectoryPathSupplier(Suppliers.of(context.getCacheDir()))
                                .setBaseDirectoryName(IMAGE_PIPELINE_CACHE_DIR)
                                .setMaxCacheSize(MAX_DISK_CACHE_SIZE)
                                .build())
                .setBitmapsConfig(Bitmap.Config.RGB_565).build();

        Fresco.initialize(context, config);
    }

    protected static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            if (width > height) {
                inSampleSize = Math.round((float) height / (float) reqHeight);
            } else {
                inSampleSize = Math.round((float) width / (float) reqWidth);
            }
            final float totalPixels = width * height;
            final float totalReqPixelsCap = reqWidth * reqHeight * 2;
            while (totalPixels / (inSampleSize * inSampleSize) > totalReqPixelsCap) {
                inSampleSize++;
            }
        }
        return inSampleSize;
    }

    /**
     * 优化bitmap内存占用 大图都应经过此方法处理
     *
     * @param resource
     * @return
     */
    public static Bitmap decodeResource(Context context, int resource, int reqWidth, int reqHeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(context.getResources(), resource, options);
        if (reqWidth > 0 && reqHeight > 0) {
            options.inSampleSize = calculateInSampleSize(options,
                    reqWidth, reqHeight);
        } else {
            options.inSampleSize = 2;
        }
        options.inJustDecodeBounds = false;
        Bitmap bm = BitmapFactory.decodeResource(context.getResources(), resource, options);
        return bm;
    }

    public static ImageDisplayBuilder with(SimpleDraweeView imageView) {
        return new ImageDisplayBuilder(imageView);
    }

//    public static void fetch(String url, final FetchBitmapListener listener) {
//        if (listener != null) {
//            fetch(Uri.parse(url), listener);
//        }
//    }

//    public static void fetch(final Uri uri, final FetchBitmapListener listener) {
//        if (listener != null) {
//            ImageRequestBuilder requestBuilder = ImageRequestBuilder.newBuilderWithSource(uri);
//            ImageRequest imageRequest = requestBuilder.build();
//            DataSource<CloseableReference<CloseableImage>> dataSource = ImagePipelineFactory.getInstance().getImagePipeline().fetchDecodedImage(imageRequest, null);
//            dataSource.subscribe(new BaseBitmapDataSubscriber() {
//                                     @Override
//                                     public void onNewResultImpl(final Bitmap bitmap) {
//                                         if (bitmap != null && !bitmap.isRecycled()) {
//                                             if (listener.onInterceptBitmapProcess()) {
//                                                 listener.onFetchBitmapFailure(new InterruptedException("bitmap process interrupted by user"));
//                                             } else {
//                                                 PageManager.runOnUiThread(new Runnable() {
//                                                     @Override
//                                                     public void run() {
//                                                         listener.onFetchBitmapSuccess(bitmap);
//                                                     }
//                                                 }, 0);
//                                             }
//                                         } else {
//                                             listener.onFetchBitmapFailure(null);
//                                         }
//                                     }
//
//                                     @Override
//                                     public void onCancellation(DataSource<CloseableReference<CloseableImage>> dataSource) {
//                                         super.onCancellation(dataSource);
//                                         listener.onFetchBitmapFailure(dataSource == null ? null : dataSource.getFailureCause());
//                                     }
//
//                                     @Override
//                                     public void onFailureImpl(DataSource dataSource) {
//                                         listener.onFetchBitmapFailure(dataSource == null ? null : dataSource.getFailureCause());
//                                     }
//                                 },
//                    CallerThreadExecutor.getInstance());
//        }
//    }

    public static class ImageDisplayBuilder {
        SimpleDraweeView mImageView = null;
        GenericDraweeHierarchy mHierarchy = null;
        ImageRequestBuilder mRequestBuilder = null;
        PipelineDraweeControllerBuilder mControllerBuilder = null;
        GenericDraweeHierarchyBuilder mHierarchyBuilder = null;
        AtomicInteger mHierarchyBuilderReferenceCount = new AtomicInteger(0);

        ImageDisplayBuilder(SimpleDraweeView imageView) {
            this.mImageView = imageView;
            mHierarchy = imageView.getHierarchy();
        }

        private ImageRequestBuilder ensureImageRequest() {
            if (mRequestBuilder == null) {
                mRequestBuilder = ImageRequestBuilder.newBuilderWithSource(Uri.EMPTY);
            }
            return mRequestBuilder;
        }

        private PipelineDraweeControllerBuilder ensureDraweeController() {
            if (mControllerBuilder == null) {
                mControllerBuilder = Fresco.newDraweeControllerBuilder();
            }
            return mControllerBuilder;
        }

        private GenericDraweeHierarchyBuilder ensureDraweeHierarchy() {
            if (mHierarchyBuilder == null) {
                mHierarchyBuilder = new GenericDraweeHierarchyBuilder(mImageView.getResources());
            }
            mHierarchyBuilderReferenceCount.incrementAndGet();
            return mHierarchyBuilder;
        }

        public ImageDisplayBuilder round(float round) {
            return round == 0 ? this :
                    round < 0 ? round(RoundingParams.asCircle()) :
                            round(RoundingParams.fromCornersRadius(round));
        }

        public ImageDisplayBuilder round(RoundingParams params) {
            if (mHierarchy != null) {
                mHierarchy.setRoundingParams(params);
            }
            ensureDraweeHierarchy().setRoundingParams(params);
            mHierarchyBuilderReferenceCount.decrementAndGet();
            return this;
        }

        public ImageDisplayBuilder focusCrop(float relativeX, float relativeY) {
            if (relativeX < 0) {
                relativeX = 0.5f;
            }
            if (relativeY < 0) {
                relativeY = 0.5f;
            }
            if (relativeX > 1) {
                relativeX = 1;
            }
            if (relativeY > 1) {
                relativeY = 1;
            }
            PointF pointF = new PointF(relativeX, relativeY);
            if (mHierarchy != null) {
                mHierarchy.setActualImageScaleType(ScalingUtils.ScaleType.FOCUS_CROP);
                mHierarchy.setActualImageFocusPoint(pointF);
            }
            ensureDraweeHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FOCUS_CROP).setActualImageFocusPoint(pointF);
            mHierarchyBuilderReferenceCount.decrementAndGet();
            return this;
        }

        public ImageDisplayBuilder holderImage(Drawable drawable) {
            if (mHierarchy != null) {
                mHierarchy.setPlaceholderImage(drawable);
            }
            ensureDraweeHierarchy().setPlaceholderImage(drawable);
            mHierarchyBuilderReferenceCount.decrementAndGet();
            return this;
        }

        public ImageDisplayBuilder holderImage(int resId) {
            return holderImage(mImageView.getResources().getDrawable(resId));
        }

        public ImageDisplayBuilder scaleType(ScalingUtils.ScaleType scaleType) {
            if (mHierarchy != null) {
                mHierarchy.setActualImageScaleType(scaleType);
            }
            ensureDraweeHierarchy().setActualImageScaleType(scaleType);
            mHierarchyBuilderReferenceCount.decrementAndGet();
            return this;
        }

        public ImageDisplayBuilder fadeDuration(int duration) {
            ensureDraweeHierarchy().setFadeDuration(duration);
            return this;
        }

        public ImageDisplayBuilder background(Drawable drawable) {
            ensureDraweeHierarchy().setBackground(drawable);
            return this;
        }

        public ImageDisplayBuilder failureImage(Drawable drawable, ScalingUtils.ScaleType scaleType) {
            if (scaleType == null) {
                ensureDraweeHierarchy().setFailureImage(drawable);
            } else {
                ensureDraweeHierarchy().setFailureImage(drawable, scaleType);
            }
            return this;
        }

        public ImageDisplayBuilder retryImage(Drawable drawable, ScalingUtils.ScaleType scaleType) {
            if (scaleType == null) {
                ensureDraweeHierarchy().setRetryImage(drawable);
            } else {
                ensureDraweeHierarchy().setRetryImage(drawable, scaleType);
            }
            return this;
        }

        public ImageDisplayBuilder progressBar(Drawable drawable, ScalingUtils.ScaleType scaleType) {
            if (scaleType == null) {
                ensureDraweeHierarchy().setProgressBarImage(drawable);
            } else {
                ensureDraweeHierarchy().setProgressBarImage(drawable, scaleType);
            }
            return this;
        }

        public ImageDisplayBuilder overlay(Drawable drawable) {
            ensureDraweeHierarchy().setOverlay(drawable);
            return this;
        }


        public ImageDisplayBuilder callContext(Object calContext) {
            ensureDraweeController().setCallerContext(calContext);
            return this;
        }

        public ImageDisplayBuilder tabReload(boolean enable) {
            ensureDraweeController().setTapToRetryEnabled(enable);
            return this;
        }

        public ImageDisplayBuilder listener(ControllerListener controllerListener) {
            //对所有的图片加载，onFinalImageSet 或者 onFailure 都会被触发;
            ensureDraweeController().setControllerListener(controllerListener);
            return this;
        }


        public ImageDisplayBuilder reSize(int width, int height) {
            ensureImageRequest().setResizeOptions(new ResizeOptions(width, height));
            return this;
        }

        public ImageDisplayBuilder renderProgressive(boolean enable) {
            ensureImageRequest().setProgressiveRenderingEnabled(enable);
            return this;
        }

        public ImageDisplayBuilder requestLevel(int requestLevel) {
            ImageRequest.RequestLevel level = null;
            if (requestLevel == ImageDisplay.REQUEST_LEVEL_FULL) {
                level = ImageRequest.RequestLevel.FULL_FETCH;
            } else if (requestLevel == ImageDisplay.REQUEST_LEVEL_MEMORY) {
                level = ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE;
            } else {
                level = ImageRequest.RequestLevel.FULL_FETCH;
            }
            ensureImageRequest().setLowestPermittedRequestLevel(level);
            return this;
        }

        public ImageDisplayBuilder aspectRatio(float ratio) {
            mImageView.setAspectRatio(ratio);
            return this;
        }

        public void display(Uri uri) {
            if (mHierarchyBuilderReferenceCount.get() > 0) {
                mImageView.setHierarchy(mHierarchyBuilder.build());
            }
            mHierarchy = null;
            if (uri != null) {
                if (mRequestBuilder != null && mControllerBuilder == null) {
                    mControllerBuilder = ensureDraweeController();
                }
                if (mControllerBuilder != null) {
                    if (mRequestBuilder != null) {
                        mControllerBuilder.setImageRequest(mRequestBuilder.setSource(uri).build());
                    } else {
                        mControllerBuilder.setUri(uri);
                    }
                    mImageView.setController(mControllerBuilder.setOldController(mImageView.getController()).build());
                } else {
                    mImageView.setImageURI(uri);
                }
            }
        }

        public void display(String url) {
            Uri uri = null;
            try {
                uri = Uri.parse(url);
            } catch (Exception e) {
                e.printStackTrace();
            }
            display(uri);
        }

        public void display(int resId) {
            display("res://" + mImageView.getResources().getResourcePackageName(resId) + "/" + resId);
        }

    }

    public interface FetchBitmapListener {
        boolean onInterceptBitmapProcess();

        /**
         * 这里的bitmap 不会为null,其回收过程需要开发者维护。
         *
         * @param bitmap
         */
        void onFetchBitmapSuccess(Bitmap bitmap);

        void onFetchBitmapFailure(Throwable error);
    }
}