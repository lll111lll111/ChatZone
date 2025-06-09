export interface GetImageRequest{
  path: string;
}

export interface GetImageResponse {
  url: string;
}

export interface ImageResource {
  content: Blob;
  filename: string;
  contentType: string;
}