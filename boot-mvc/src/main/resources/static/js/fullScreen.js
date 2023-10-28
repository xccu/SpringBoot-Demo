/*!
 * admin.html页面控制浏览器全屏
 * 2020-12-29
 */

var fullscreen=false;
$('.fullscreen').on('click', function(){
    if(!fullscreen){
        enterFullscreen();
    }
    else{
        exitFullscreen();
    }
})

function enterFullscreen() {
    var docElm = document.documentElement;
    //W3C
    if(docElm.requestFullscreen) {
        docElm.requestFullscreen();
    }
    //FireFox
    else if(docElm.mozRequestFullScreen) {
        docElm.mozRequestFullScreen();
    }
    //Chrome等
    else if(docElm.webkitRequestFullScreen) {
        docElm.webkitRequestFullScreen();
    }
    //IE11
    else if(docElm.msRequestFullscreen) {
        docElm.msRequestFullscreen();
    }

    fullscreen=true;
    $('.layui-icon-screen-full').attr('class','layui-icon layui-icon-screen-restore')
}

function exitFullscreen() {
    //W3C
    if (document.exitFullscreen) {
        document.exitFullscreen();
    }
    //FireFox
    else if (document.mozCancelFullScreen) {
        document.mozCancelFullScreen();
    }
    //Chrome等
    else if (document.webkitCancelFullScreen) {
        document.webkitCancelFullScreen();
    }
    //IE11
    else if (document.msExitFullscreen) {
        document.msExitFullscreen();
    }

    fullscreen=false;
    $('.layui-icon-screen-restore').attr('class','layui-icon layui-icon-screen-full')
}