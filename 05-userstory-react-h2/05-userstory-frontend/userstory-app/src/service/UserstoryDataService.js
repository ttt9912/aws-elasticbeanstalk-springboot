import axios from 'axios';

const API_URL = 'http://localhost:5000/userstories';

class UserstoryDataService {

    findAll() {
        return axios.get(`${API_URL}`);
    }

    findById(id) {
        return axios.get(`${API_URL}/${id}`);
    }

    delete(id) {
        return axios.delete(`${API_URL}/${id}`);
    }

    create(userstory) {
        return axios.post(`${API_URL}`, userstory);
    }

    update(userstory) {
        return axios.put(`${API_URL}`, userstory);
    }
}

export default new UserstoryDataService()