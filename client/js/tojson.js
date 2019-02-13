/**
 * Created by Administrator on 2017/3/1.
 */
//把表单对象转成JSON格式,兼容以.的形式的多层对象

$.fn.serializeObject = function() {
    var o = {};
    var a = this.serializeArray();
    var regArray = /^([^\[\]]+)\[(\d+)\]$/;

    $.each(a, function(i) {
        var name = this.name;
        var value = this.value;

        // let's also allow for "dot notation" in the input names
        var props = name.split('.');
        var position = o;
        while (props.length) {
            var key = props.shift();
            var matches;
            if (matches = regArray.exec(key)) {
                var p = matches[1];
                var n = matches[2];
                if (!position[p]) position[p] = [];
                if (!position[p][n]) position[p][n] = {};
                position = position[p][n];
            } else {
                if (!props.length) {
                    if (!position[key]) position[key] = value || '';
                    else if (position[key]) {
                        if (!position[key].push) position[key] = [position[key]];
                        position[key].push(value || '');
                    }
                } else {
                    if (!position[key]) position[key] = {};
                    position = position[key];
                }
            }
        }
    });
    return o;
};

//$("#result").html(JSON.stringify($('form').serializeObject()));
// $(function() {
//     $('form').submit(function() {
//         $('#result').text(JSON.stringify($('form').serializeObject()));
//         return false;
//     });
// });