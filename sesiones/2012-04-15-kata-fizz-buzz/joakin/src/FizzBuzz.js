
var fizzbuzz = {

    resolve: function() {

        var r = [];
        for(var i = 1; i <= 100; i++) {
            r.push(fizzbuzz.parseNumber(i));
        }
        return r.join(' ');
    },

    parseNumber: function(num) {

        var r = '';
        if (fizzbuzz.check(num, 3))
            r += "Fizz";
        if (fizzbuzz.check(num, 5))
            r += "Buzz";
        if (!r.length)
            r += num;
        return r;
    },

    check: function(num, base) {

        return fizzbuzz.module(num, base) || fizzbuzz.contains(num, base);
    },

    module: function(num, base) {

        return num % base == 0;
    },

    contains: function(num, base) {

        return (num + '').indexOf(base + '') != -1;
    }
};
