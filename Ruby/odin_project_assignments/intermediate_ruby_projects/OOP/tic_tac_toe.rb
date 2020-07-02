module DisplayGame
  def print_game(arr)
    arr.each do |sub|
      sub.each do |chara|
        print chara + ' | '
      end
      puts
    end
  end
end

class Game
  include DisplayGame
  @@MOVE_HASH = {'a' => 1, 'b' => 2, 'c' => 3, '1' => 1, '2' => 2, '3' => 3}
  @@current_game = [
    [' ', 'a', 'b', 'c'],
    ['1', ' ', ' ', ' '],
    ['2', ' ', ' ', ' '],
    ['3', ' ', ' ', ' ']
  ]
  attr_accessor :game_end
  @game_end = false

  def initialize
    self.print_game(@@current_game)
  end

  def player_move(cur_player)
    symbol = nil
    if cur_player.even?
      print 'Player One, make your move: '
      symbol = 'X'
    else
      print 'Player Two, make your move: '
      symbol = 'O'
    end
    move = gets.chomp.gsub(/\s+/, '').downcase.split('')
    x = nil
    y = nil
    if 'abc'.include?(move[0])
      x = move[0]
      y = move[1]
    else
      x = move[1]
      y = move[0]
    end
    @@current_game[@@MOVE_HASH[y]][@@MOVE_HASH[x]] = symbol
    self.print_game(@@current_game)
  end

  def game_over
    column = [Array.new, Array.new, Array.new]
    @@current_game.each do |row|
      next if row[0] == ' '
      row_empty = !(row[1] == ' ')
      if row[1] == row[2] && row[2] == row[3] && row_empty
        return true
      else
        4.times do |i|
          next if i.zero?

          column[(i - 1)].append(row[i])
        end
      end
    end
    column.each do |col|
      next if col[0] == ' '
      return true if col.uniq.size == 1
    end
    false
  end

  def winner(moves)
    moves -= 1
    if moves.even?
      puts 'Congratulations! Player One Wins'
    else
      puts 'Congratulations! Player Two Wins'
    end
  end

end

new_game = Game.new
player_turn = 0

until new_game.game_end
  new_game.player_move(player_turn)
  player_turn += 1
  new_game.game_end = new_game.game_over
end

new_game.winner(player_turn)