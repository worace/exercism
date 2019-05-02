Match = Struct.new(:teams, :winner)

module Tournament
  extend self

  def header
    "Team                           | MP |  W |  D |  L |  P"
  end

  def winner(left, right, result)
    case result
    when "win"
      left
    when "loss"
      right
    when "draw"
      nil
    end
  end

  def parse(input)
    matches = input.split("\n").map do |line|
      left, right, result = line.split(";")
      Match.new([left, right], winner(left, right, result))
    end
  end

  def team_record(team, matches)
    counts = {team: team, mp: 0, w: 0, d: 0, l: 0, p: 0}
    matches.each do |match|
      if match.teams.include?(team)
        counts[:mp] += 1
        case match.winner
        when team
          counts[:w] += 1
          counts[:p] += 3
        when nil
          counts[:d] += 1
          counts[:p] += 1
        else
          counts[:l] += 1
        end
      end
    end
    counts
  end

  def num_column(number)
    number.to_s.rjust(3) + " "
  end

  def format_row(record)
    team = record.delete(:team)
    columns = record.values.map { |n| num_column(n) }
    columns.unshift(team.ljust(31))
    columns.join("|").rstrip
  end

  def tally(input)
    matches = parse(input) # [ {teams: [a,b], winner: b} ]
    teams = matches.flat_map(&:teams).uniq
    team_records = teams.map { |t| team_record(t, matches) }.sort_by { |rec| [-rec[:p], rec[:team]] }
    team_rows = team_records.map { |rec| format_row(rec) }
    ([header] + team_rows).join("\n") + "\n"
  end
end
