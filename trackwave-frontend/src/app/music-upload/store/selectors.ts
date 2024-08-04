import { createFeature, createFeatureSelector, createSelector } from "@ngrx/store";
import { musicUploadFeatureKey } from "src/app/music-upload/store/reducers";
import { MusicUploadStateInterface } from "src/app/music-upload/types/musicUploadState.interface";

export const musicUploadFeatureSelector = createFeatureSelector<MusicUploadStateInterface>(musicUploadFeatureKey);

export const isLoadingSelector = createSelector(
    musicUploadFeatureSelector,
    (musicUploadState: MusicUploadStateInterface) => musicUploadState.isUploading
);

export const errorSelector = createSelector(
    musicUploadFeatureSelector,
    (musicUploadState: MusicUploadStateInterface) => musicUploadState.error
);
