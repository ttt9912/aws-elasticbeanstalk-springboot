import axios from 'axios';
import {API_URL} from '../Constants'

const USERSTORIES_URL = `${API_URL}/userstories`;

class UserstoryDataService {

    findAll() {
        return axios.get(`${USERSTORIES_URL}`);
    }

    findById(id) {
        return axios.get(`${USERSTORIES_URL}/${id}`);
    }

    delete(id) {
        return axios.delete(`${USERSTORIES_URL}/${id}`);
    }

    create(userstory) {
        return axios.post(`${USERSTORIES_URL}`, userstory);
    }

    update(userstory) {
        return axios.put(`${USERSTORIES_URL}`, userstory);
    }
}

export default new UserstoryDataService()