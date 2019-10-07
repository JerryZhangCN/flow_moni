var appLightbox = Vue.component('appLightbox', {
    template: "<div id='overlay' @click='close'>" +
    "<img :src='imgsource.imgUrl' alt='' />" +
    "<span>{{ imgsource.caption }}</span>" +
    "</div>",
    props: {
        imgsource: Object,
        close: Function
    },
  mounted: function() {
    var overlay = document.getElementById('overlay');
    overlay.setAttribute('style', 'height:' + window.innerHeight + 'px; ' + 'width:' + window.innerWidth + 'px');
    console.log(window.innerWidth);
  }
});


var app = new Vue({
    el: '#app',
    components: {
        appLightbox: appLightbox
    },
    data: {
        picdata: [
            {
                id: 1,
                //caption: 'Magnificient Butterfly',//
                imgUrl: 'images/a2.png'
            },
            ],
        currentPic: '',
        lightBoxToggle: false
    },
    methods: {
        openBox: function(d) {
            this.currentPic = d;
            this.lightBoxToggle = !this.lightBoxToggle;
        },
        closeBox: function() {
            this.lightBoxToggle = false;
        }
    }
});