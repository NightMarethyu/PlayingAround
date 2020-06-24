def caesar_cipher(key, input)
  coded = []
  input.split('').each_with_index do |c, index|
    temp = c.ord
    new_char = ""
    if temp >= 65 && temp <= 91
      new_char = (65 + (((temp - 65) + key) % 26)).chr
    elsif temp >= 97 && temp <= 123
      new_char = (97 + (((temp - 97) + key) % 26)).chr
    else
      new_char = temp.chr
    end
    coded[index] = new_char
  end
  coded.join('')
end

print "Enter the plaintext statement: "
input = gets.chomp
print "Enter the key: "
key = gets.chomp.to_i
puts caesar_cipher(key, input)