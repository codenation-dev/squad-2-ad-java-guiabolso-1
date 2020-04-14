import axios from "axios"
import { getToken } from "./auth"

const proxy = "https://cors-anywhere.herokuapp.com/"
const url = "https://squad2-central-erros.herokuapp.com"

const api = axios.create({
  baseURL: proxy + url
})

api.interceptors.request.use(async config => {
  const token = getToken()
  if (token) {
    config.headers.Authorization = `Bearer ${token}`
  }
  return config
});

export default api