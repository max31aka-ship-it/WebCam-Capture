#!/usr/bin/env ruby
# webcam.rb
# encoding: UTF-8

require 'opencv'
require 'optparse'

options = { output: 'snapshot.jpg', device: 0, delay: 0 }

OptionParser.new do |opts|
  opts.banner = "Usage: webcam.rb [options]"
  opts.on('-o', '--output FILE', 'Выходной файл') { |v| options[:output] = v }
  opts.on('-d', '--device N', Integer, 'Индекс камеры') { |v| options[:device] = v }
  opts.on('-t', '--delay N', Integer, 'Задержка в секундах') { |v| options[:delay] = v }
  opts.on('-h', '--help', 'Справка') { puts opts; exit }
end.parse!

include OpenCV

capture = CvCapture.open(options[:device])
unless capture
  STDERR.puts "Ошибка: не удалось открыть камеру"
  exit 1
end

if options[:delay] > 0
  puts "Ожидание #{options[:delay]} секунд..."
  sleep options[:delay]
end

frame = capture.query
unless frame
  STDERR.puts "Ошибка: не удалось захватить кадр"
  exit 1
end

frame.save(options[:output])
puts "✅ Изображение сохранено в #{options[:output]}"
