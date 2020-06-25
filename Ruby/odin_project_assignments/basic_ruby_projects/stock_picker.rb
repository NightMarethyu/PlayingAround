def stock_picker(prices)
  sorter = Hash.new(0)
  prices.each_with_index do |price, index|
    sorter[index] = price
  end
  sorted = sorter.sort_by { |index, price| price }
  reps = sorted.length
  options = []
  reps.times do |i|
    next if sorted[i] == (reps - 1)
    (reps - 1).times do |j|
      neg = -(j + 1)
      if sorted[i][0] < sorted[neg][0]
        options.append([sorted[i][0], sorted[neg][0]])
      end
    end
  end
  most = Hash.new(0)
  options.each_with_index do |opt, index|
    most[index] = prices[opt[1]] - prices[opt[0]]
  end
  best = most.sort_by { |index, gain| gain }.last
  options[best[0]]
end

print "Enter comma separated array of prices: "
prices = gets.chomp
prices = prices.split(",")
prices.map! { |price| price = price.to_i}
p stock_picker(prices)