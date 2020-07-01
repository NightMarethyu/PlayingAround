MOVE_HASH = {'a' => 1, 'b' => 2, 'c' => 3, '1' => 1, '2' => 2, '3' => 3}

start_array = [
  [' ', 'a', 'b', 'c'],
  ['1', ' ', ' ', ' '],
  ['2', ' ', ' ', ' '],
  ['3', ' ', ' ', ' ']
]

def print_game(arr)
  arr.each do |sub|
    sub.each do |chara|
      print chara + ' | '
    end
    puts
  end
end

def first_player_move(arr)
  print 'Player One, make your move (letter number): '
  move = gets.chomp.gsub(/\s+/, '').downcase.split('')
  arr[MOVE_HASH[move[1]]][MOVE_HASH[move[0]]] = 'X'
end

def second_player_move(arr)
  print 'Player Two, make your move (letter number): '
  move = gets.chomp.gsub(/\s+/, '').downcase.split('')
  arr[MOVE_HASH[move[1]]][MOVE_HASH[move[0]]] = 'O'
end

9.times do |ind|
  print_game(start_array)
  if ind.even?
    first_player_move(start_array)
  else
    second_player_move(start_array)
  end
end