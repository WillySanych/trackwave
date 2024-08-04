import { createReducer, on } from "@ngrx/store";
import { musicUploadAction, musicUploadActionFailure, musicUploadActionSuccess } from "src/app/music-upload/store/actions/musicUpload.action";
import { MusicUploadStateInterface } from "src/app/music-upload/types/musicUploadState.interface";

const initialState: MusicUploadStateInterface = {
    isUploading: false,
    error: false
}

export const musicUploadFeatureKey: string = 'music-upload';

export const musicUploadReducer = createReducer(
    initialState,
    on(
        musicUploadAction,
        (state): MusicUploadStateInterface => ({
            ...state,
            isUploading: true,
            error: false
        })
    ),
    on(
        musicUploadActionSuccess,
        (state): MusicUploadStateInterface => ({
            ...state,
            isUploading: false,
            error: false
        })
    ),
    on(
        musicUploadActionFailure,
        (state) => ({
            ...state,
            isUploading: false,
            error: true
        })
    )
);
