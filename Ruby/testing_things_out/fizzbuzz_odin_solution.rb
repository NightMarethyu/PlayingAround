print "Please enter the number you would like to FizzBuzz up to: "
max_num = gets.chomp.to_i

1.upto(max_num) do |cur_num|
  if cur_num % 3 == 0 && cur_num % 5 == 0
    puts "FizzBuzz"
  elsif cur_num % 3 == 0
    puts "Fizz"
  elsif cur_num % 5 == 0
    puts "Buzz"
  else
    puts cur_num
  end
end