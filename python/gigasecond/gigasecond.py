from datetime import timedelta

gigasecond = timedelta(seconds = 10**9)

def add_gigasecond(dt):
    return dt + gigasecond
