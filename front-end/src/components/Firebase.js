import { initializeApp } from "firebase/app";

import { getStorage, ref } from "firebase/storage";
import { getApp } from "firebase/app";
const firebaseConfig = {
  apiKey: "AIzaSyDaiU9E4bdnb7Ig1s9LhObKCgrPbZmF41A",
  authDomain: "hook-in.firebaseapp.com",
  projectId: "hook-in",
  storageBucket: "hook-in.appspot.com",
  messagingSenderId: "882969921352",
  appId: "1:882969921352:web:c1e1b877db493dcb71557d"
};

const app = initializeApp(firebaseConfig);

export const storage = getStorage(app);
export const firebaseApp = getApp();

export  const storageRef = ref(storage);