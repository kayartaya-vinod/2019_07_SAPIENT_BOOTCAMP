const Axios = require("axios");

var video_id = 'KOdfpbnWLVo';
const api_key = 'AIzaSyDHYYwvPBN-Jwr827it81B2b7HN22bM0xI';
const part = 'contentDetails,snippet'; // snippet, contentDetails
const url = `https://www.googleapis.com/youtube/v3/videos?id=${video_id}&key=${api_key}&part=${part}`;

format = duration => {
    duration = duration.substr(2);
    duration = duration.split('M');
    return `${duration[0]}:${duration[1].split('S')[0]}`;
}
Axios.get(url)
    .then(data => {
        let { items } = data.data;
        // for (var key in data.data) {
        //     console.log(key);
        // }
        // console.log('---------')
        items.forEach(item => {
            let { title, description } = item.snippet;
            // for (var key in item.snippet) {
            //     console.log(key);
            // }
            // console.log('---------')
            let { duration } = item.contentDetails;
            // for (var key in item.contentDetails) {
            //     console.log(key);
            // }
            console.log('title', title);
            // console.log('description', description);
            console.log('duration', format(duration));
        });
    })
    .catch(err => console.log('there is an error', err));