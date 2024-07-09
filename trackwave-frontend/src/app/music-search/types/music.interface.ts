import { AuthorInterface } from "src/app/music-search/types/author.interface";

export interface MusicInterface {
    id: number,
    name: string,
    author: AuthorInterface
}