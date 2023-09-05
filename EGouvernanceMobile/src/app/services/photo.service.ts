import { Injectable } from '@angular/core';
import { Camera , CameraResultType} from '@capacitor/camera';
@Injectable({
  providedIn: 'root'
})
export class PhotoService {

  constructor() { }

  async takePicture(){
    const image = await Camera.getPhoto({
      quality:90,
      allowEditing:true,
      resultType:CameraResultType.DataUrl
    });
    return image.dataUrl || "";
  }
}
