class Clock(object):
    def __init__(self, hours, minutes):
        self.hours = hours
        self.minutes = minutes

    def cumulative_hours(self):
        return (self.hours + self.minutes / 60) % 24

    def cumulative_minutes(self):
        return self.minutes % 60

    def cumulative_time(self):
        return (self.cumulative_hours(), self.cumulative_minutes())

    def hh(self):
        return str(self.cumulative_hours()).zfill(2)

    def mm(self):
        return str(self.cumulative_minutes()).zfill(2)

    def add(self, minutes):
        return Clock(self.hours, self.minutes + minutes)

    def hhmm(self):
        return (self.hh(), self.mm())

    def __repr__(self):
        return ":".join(self.hhmm())

    def __eq__(self, other):
        return self.cumulative_time() == other.cumulative_time()
