(function ($) {
    "use strict";
    var time = "";

    $.extend({
        getCurrentTime:function() {
            var nowDate = new Date();
            var year = nowDate.getFullYear();
            var month = standardNumber(nowDate.getMonth() + 1);
            var day = standardNumber(nowDate.getDate());
            var hour = standardNumber(nowDate.getHours());
            var miunte = standardNumber(nowDate.getMinutes());
            var second = standardNumber(nowDate.getSeconds());
            return year + "-" + month + "-" + day + " " + hour + ":" + miunte + ":" + second;
        }
    });

    function standardNumber(t) {
        return t < 10 ? "0" + t : t;
    }

    $.fn.showCurrentTime = function () {
        var timeContainer = $(this);
        setInterval(function () {
            time = getCurrentTime();
            timeContainer.html(time);
        }, 1000);
    };

})(jQuery);