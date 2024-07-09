import { createFeatureSelector, createSelector } from "@ngrx/store";
import { MusicSearchStateInterface } from "src/app/music-search/types/musicSearchState.interface";

export const musicSearchFeatureSelector = createFeatureSelector<MusicSearchStateInterface>('music-search');

export const isLoadingSelector = createSelector(
    musicSearchFeatureSelector,
    (musicSearchState: MusicSearchStateInterface) => musicSearchState.isLoading
);

export const musicListSelector = createSelector(
    musicSearchFeatureSelector,
    (musicSearchState: MusicSearchStateInterface) => musicSearchState.musicList
);

export const errorSelector = createSelector(
    musicSearchFeatureSelector,
    (musicSearchState: MusicSearchStateInterface) => musicSearchState.error
);
