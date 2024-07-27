import { MusicInterface } from "src/app/share/types/music.interface";


export interface MusicSearchStateInterface {
    isLoading: boolean,
    musicList: MusicInterface[] | null,
    error: boolean | null
}