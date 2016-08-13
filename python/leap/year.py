def div_by(num, denom):
    return num % denom == 0

def is_leap_year(year):
    return (div_by(year, 4) and not div_by(year, 100)) or div_by(year, 400)
