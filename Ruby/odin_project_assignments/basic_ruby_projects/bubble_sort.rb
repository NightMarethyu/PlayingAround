def bubble_sort(input)
  input.length.times do |j|
    high = input[0]
    (input.length - 1).times do |i|
      if high > input[i + 1]
        temp = input[i + 1]
        input[i + 1] = high
        input[i] = temp
      else
        high = input[i + 1]
      end
    end
  end
  input
end

print 'Please enter an array as a comma separated list: '
user_array = gets.chomp.split(',').map! { |num| num = num.to_i }
puts bubble_sort(user_array)