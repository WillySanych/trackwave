import { createFeatureSelector, createSelector } from "@ngrx/store";
import { playerFeatureKey } from "src/app/share/player/store/reducers";
import { PlayerStateInterface } from "src/app/share/player/types/playerState.interface";

export const playerFeatureSelector = createFeatureSelector<PlayerStateInterface>(playerFeatureKey);

export const selectedMusicSelector = createSelector(
    playerFeatureSelector,
    (playerState: PlayerStateInterface) => playerState.selectedMusic
);
