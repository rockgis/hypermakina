function  chart_gauge(source,data) {

    var chart = bb.generate({
        data: {
            columns: data,
            type: "gauge", // for ESM specify as: gauge()
            onclick: function (d, i) {
                console.log("onclick", d, i);
            },
            onover: function (d, i) {
                console.log("onover", d, i);
            },
            onout: function (d, i) {
                console.log("onout", d, i);
            }
        },
        gauge: {},
        color: {
            pattern: [
                "#60B044",
                "#F6C600",
                "#F97600",
                "#FF0000"
            ],
            threshold: {
                values: [
                    30,
                    60,
                    90,
                    100
                ]
            }
        },
        size: {
            height: 180
        },
        legend: {
            show: false
        },
        bindto: source
    });

}

var diskdata = [["C", 60], ["D", 80], ["E", 25]];
function polarChart(source){
    var chart = bb.generate({
        data: {
            columns: diskdata,
            type: "polar", // for ESM specify as: polar()
            order: null
        },
        polar: {
            label: {
                format: function(value, ratio, id) { return value +"\n+" + (ratio * 100).toFixed(0) +"%"; },
                ratio: 1.07
            },
            level: {
                depth: 5,
                max: 100,
                text: {
                    backgroundColor: "white"
                }
            }
        },
        bindto: source
    });
}


function getDateRangeData(param1, param2){  //param1은 시작일, param2는 종료일이다.
    var res_day = [];
    var ss_day = new Date(param1);
    var ee_day = new Date(param2);
    while(ss_day.getTime() <= ee_day.getTime()){
        var _mon_ = (ss_day.getMonth()+1);
        _mon_ = _mon_ < 10 ? '0'+_mon_ : _mon_;
        var _day_ = ss_day.getDate();
        _day_ = _day_ < 10 ? '0'+_day_ : _day_;
        res_day.push(ss_day.getFullYear() + '-' + _mon_ + '-' +  _day_);
        ss_day.setDate(ss_day.getDate() + 1);
    }
    return res_day;
}


function getSecondDateRangeData(param1, param2){  //param1은 시작일, param2는 종료일이다.
    var res_day = [];
    var ss_day = new Date(param1);
    var ee_day = new Date(param2);
    res_day.push(param1);
    while(ss_day.getTime() <= ee_day.getTime()){
        var _mon_ = (ss_day.getMonth()+1);
        _mon_ = _mon_ < 10 ? '0'+_mon_ : _mon_;
        var _day_ = ss_day.getDate();
        _day_ = _day_ < 10 ? '0'+_day_ : _day_;

        var _hour_ = ss_day.getHours();
        _hour_ = _hour_ < 10 ? '0'+_hour_ : _hour_;

        var _min_ = ss_day.getMinutes();
        if(_min_ < 59){
            _min_ = _min_ + 1;
            if(_min_ < 10){
                _min_ = '0' + _min_;
            }
        } else {
            _min_ = "00";
        }

        var _sec_ = ss_day.getSeconds();
        if(_sec_ < 59){
            _sec_ = _sec_ + 1;
            if(_sec_ < 10){
                _sec_ = '0' + _sec_;
            }
        } else {
            _sec_ = "00";
        }
        res_day.push(ss_day.getFullYear() + '-' + _mon_ + '-' +  _day_ + ' ' + _hour_ + ':' + _min_ + ':' + _sec_);
        ss_day.setSeconds(ss_day.getSeconds() + 1);
    }
    return res_day;
}
