import React, { Component } from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import { render } from 'react-dom';
import Axios from 'axios';
import slugify from 'slugify';
import './YoutubeDataGrabber.css';

const api_key = 'AIzaSyDHYYwvPBN-Jwr827it81B2b7HN22bM0xI';
const part = 'contentDetails,snippet'; // snippet, contentDetails

const format = duration => {
    duration = duration.substr(2);
    duration = duration.split('M');
    let m, s;
    m = duration[0]
    s = duration[1].split('S')[0];
    if (s < 10) s = '0' + s;

    return `${m}:${s}`;
}

class YoutubeDataGrabber extends Component {
    state = {
        videoIds: ['iAzShkKzpJo', 'bY6m6_IIN94', 'c59Qzq_03CY', 'KOdfpbnWLVo'],
        lessons: [],
        theClass: ''
    }

    deleteVideo = (id) => {
        let videoIds = [...this.state.videoIds];
        let index = videoIds.findIndex(vid => vid === id);
        videoIds.splice(index, 1);
        this.setState({ videoIds });
    }

    addVideoButtonHandler = (evt) => {
        evt.preventDefault();

        let { vidId } = this.refs;
        vidId.value = vidId.value.trim();
        if (!vidId.value) return;

        this.setState({ videoIds: [...this.state.videoIds, vidId.value] });
        vidId.value = '';
        vidId.focus();
    }

    getDataButtonHandler = () => {
        let { videoIds } = this.state;

        let lessons = [];

        let theClass = {};
        theClass.title = this.refs.className.value;
        theClass.id = slugify(theClass.title.toLowerCase());
        theClass.lessons = lessons;
        this.setState({ theClass });

        videoIds.forEach((id, index) => {
            let url = `https://www.googleapis.com/youtube/v3/videos?id=${id}&key=${api_key}&part=${part}`;
            Axios.get(url)
                .then(data => {
                    let { items } = data.data;
                    items.forEach(item => {
                        let { title, description } = item.snippet;
                        let { duration } = item.contentDetails;
                        let slug = slugify(title);
                        let lesson = { id: index + 1, title, slug, description, duration: format(duration), vid_id: id };
                        lessons.push(lesson);
                        this.setState({ lessons });
                    });
                });
        })
    }

    render() {
        let videoIds = null;
        videoIds = this.state.videoIds.map(id =>
            <li key={id} className="list-group-item">{id}
                <button className="btn btn-outline-danger"
                    style={{ float: 'right' }}
                    onClick={() => this.deleteVideo(id)}>x</button>
            </li>);

        return (
            <div className="container">
                <h3>Youtube Data Grabber</h3>
                <hr />

                <div className="row">
                    <div className="col-md-4">
                        <form onSubmit={this.addVideoButtonHandler}>

                            <input type="text"
                                className="form-control"
                                ref="className" placeholder="class name here" />

                            <br />

                            <input type="text"
                                className="form-control"
                                ref="vidId" placeholder="video id here" />
                            <br />
                            <button className="btn btn-primary">
                                Add video
                            </button>
                            <button className="btn btn-secondary"
                                onClick={this.getDataButtonHandler}>
                                Get data
                            </button>
                        </form>

                        <br />

                        <h5>List of video ids: </h5>
                        <ul className="list-group">
                            {videoIds}
                        </ul>

                    </div>
                    <div className="col-md-8">
                        <pre>
                            {JSON.stringify(this.state.theClass, null, 3)}
                        </pre>
                    </div>
                </div>
            </div>
        );
    }
}

render(<YoutubeDataGrabber />, document.getElementById('root'));