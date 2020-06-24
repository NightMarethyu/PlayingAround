def substrings(against, dictionary)
  user_input = Array.new(against.split)
  dictionary.reduce(Hash.new(0)) do |count, word|
    for item in user_input
      down = item.downcase
      if down.include?(word)
        count[word] += 1
      end
    end
    count
  end
end

dictionary = ["below","down","go","going","horn","how","howdy","it","i","low","own","part","partner","sit"]
print "Enter your text: "
input = gets.chomp
puts substrings(input, dictionary)