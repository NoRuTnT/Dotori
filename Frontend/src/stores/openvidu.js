import {onMounted, ref} from 'vue';
import {defineStore} from 'pinia';
import {OpenVidu} from 'openvidu-browser';

export const useOpenViduStore
  = defineStore('openViduStore', () => {

  const OV = new OpenVidu();
  const session = OV.initSession();
  const ovToken = ref(null);


  // onMounted(() => {
  //
  //   sessionStorage.setItem('ovToken', 'wss://dotori.online:5443?sessionId=ses_TjFHYfB26j&token=tok_JM6mGDG3n09Aoy46');
  //   const storedOVToken = sessionStorage.getItem('ovToken');
  //   if (storedOVToken) {
  //     console.log('onMounted 시점에 토큰 발견 : ' + storedOVToken);
  //     ovToken.value = storedOVToken;
  //     session.connect(ovToken.value).then(() => {
  //       console.log('ov와 연결 성공!');
  //     })
  //       .catch((error) => {
  //         console.error('ov와 연결 실패:', error);
  //       });
  //   } else {
  //     console.log('onMounted 시점에 토큰 발견 실패 : ');
  //   }
  // });

  const connectToOpenVidu = () => {
    // session.
    // spring 서버에서 받아둔 토큰을 sessionStorage에 저장해야 함
    session.connect("wss://dotori.online:8443?sessionId=ses_Kf1uTdDIrS&token=tok_PbRa2BKbddHcrhsu")
      .then(() => {
        console.log('ov와 연결 성공!');
      })
      .catch((error) => {
        console.error('ov와 연결 실패:', error);
      });
  };
  return {
    connectToOpenVidu,
  };
}, {persist: {storage: sessionStorage}});
