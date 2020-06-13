# loop loop is an infinite loop that can be ended with a "break if" statement

loop_loop = 0
loop do
    puts "loop loop is #{loop_loop}"
    loop_loop += 1
    break if loop_loop == 5
end

puts ""
# while loops are the same as in python just with slightly different syntax

while_loop = 1
while while_loop < 5 do
    puts "while loop is #{while_loop}"
    while_loop += 1
end

puts ""
# until loop is the reverse of a while loop, basically if you are using ! (logical not)
# in a while loop then you should use an until loop

until_loop = 1
until until_loop > 5 do
    puts "until loop is #{until_loop}"
    until_loop += 1
end

puts ""
# Ruby has ranges defined by a .. inclusive ranges are 1..5 (1, 2, 3, 4, 5)
# Exclusive ranges are defined by ... 1...5 (1, 2, 3, 4)
# the Alphabet can be used also ('a'..'d') is (a, b, c, d)

# For loops are similar to Python in that it can be a for...in... loop

for i in 0..5
    puts "#{i} zombies incoming!"
end

puts ""
# times loop is a specified number of times

5.times do |number|
    puts "Alternative fact number #{number}"
end

puts ""
# upto and downto loops are like the times loop but they count up or down

5.upto(10) {|num| print "#{num} "}
10.downto(5) {|num| print "#{num} "}

puts ""