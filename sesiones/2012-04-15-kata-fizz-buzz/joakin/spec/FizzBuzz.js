
describe('FizzBuzz', function(){

    describe('Parse number', function(){

        it('should return same', function() {
            
            expect(fizzbuzz.parseNumber(1)).toBe('1');
            expect(fizzbuzz.parseNumber(2)).toBe('2');
            expect(fizzbuzz.parseNumber(4)).toBe('4');
            expect(fizzbuzz.parseNumber(7)).toBe('7');
        });
        
        it('should return Fizz for 3', function() {
            
            expect(fizzbuzz.parseNumber(3)).toBe("Fizz");
        });

        it('should return Fizz for multiples of 3', function() {
            
            var tests = [3, 6, 9, 12];
            for (var i = 0; i < tests.length; i++) {
                expect(fizzbuzz.parseNumber(tests[i])).toBe("Fizz");
            }
        });

        it('should return Buzz for multiples of 5', function() {
            
            var tests = [5, 10, 20, 25];
            for (var i = 0; i < tests.length; i++) {
                expect(fizzbuzz.parseNumber(tests[i])).toBe("Buzz");
            }
        });

        it('should return FizzBuzz for multiples of 3 and 5', function() {
            
            var tests = [15, 30, 60];
            for (var i = 0; i < tests.length; i++) {
                expect(fizzbuzz.parseNumber(tests[i])).toBe("FizzBuzz");
            }
        });

        it('should return Fizz if number contains 3', function() {

            var tests = [13, 23, 31];
            for (var i = 0; i < tests.length; i++) {
                expect(fizzbuzz.parseNumber(tests[i])).toBe("Fizz");
            }
        });

        it('should return Buzz if number contains 5', function() {

            var tests = [52, 151, 25];
            for (var i = 0; i < tests.length; i++) {
                expect(fizzbuzz.parseNumber(tests[i])).toBe("Buzz");
            }
        });

        it('should return FizzBuzz if number contains 5 and 3', function() {

            var tests = [35, 53, 135];
            for (var i = 0; i < tests.length; i++) {
                expect(fizzbuzz.parseNumber(tests[i])).toBe("FizzBuzz");
            }
        });

        // TODO: test mixins of multiples and string contain.
    });
});
