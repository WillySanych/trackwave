import { createAction, props } from "@ngrx/store";
import { ActionTypes } from "src/app/music-upload/store/actionTypes";
import { MusicUploadRequestInterface } from "src/app/music-upload/types/musicUploadRequest.interface";

export const musicUploadAction = createAction(
    ActionTypes.UPLOAD_MUSIC,
    props<{musicUploadRequest: MusicUploadRequestInterface}>()
);

export const musicUploadActionSuccess = createAction(
    ActionTypes.UPLOAD_MUSIC_SUCCESS
);

export const musicUploadActionFailure = createAction(
    ActionTypes.UPLOAD_MUSIC_FAILURE
);
