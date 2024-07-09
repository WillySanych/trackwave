import { createReducer, on } from "@ngrx/store";
import { getMusicAction, getMusicActionFailure, getMusicActionSuccess } from "src/app/music-search/store/actions/getMusic.action";
import { MusicSearchStateInterface } from "src/app/music-search/types/musicSearchState.interface";

const initiaState: MusicSearchStateInterface = {
    isLoading: false,
    musicList: null,
    error: null
}

export const musicSearchFeatureKey: string = "music-search";

export const musicSearchReducer = createReducer(
    initiaState,
    on(
        getMusicAction,
        (state): MusicSearchStateInterface => ({
            ...state,
            isLoading: true,
            error: false
        })
    ),
    on(
        getMusicActionSuccess,
        (state, action): MusicSearchStateInterface => ({
            ...state,
            musicList: action.musicResponse,
            error: false
        }) 
    ),
    on(
        getMusicActionFailure,
        (state): MusicSearchStateInterface => ({
            ...state,
            musicList: null,
            error: true
        })
    )
);
