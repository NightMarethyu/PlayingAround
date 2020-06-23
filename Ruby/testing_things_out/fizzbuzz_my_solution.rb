puts "Enter a number: "
user_number = gets

unless user_number.is_a? Integer do
  puts "Please enter a number: "
  user_number = gets
end

user_number = user_number.to_i

count = 1
while count < user_number do
  if count % 3 == 0
    if count % 5 == 0
      puts "FizzBuzz"
    else
      puts "Fizz"
    end
  elsif count % 5 == 0
    puts "Buzz"
  else
    puts count
  end
  count += 1
end
end