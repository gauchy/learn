"""You can use this class to represent how classy someone
or something is.
"Classy" is interchangable with "fancy".
If you add fancy-looking items, you will increase
your "classiness".
Create a function in "Classy" that takes a string as
input and adds it to the "items" list.
Another method should calculate the "classiness"
value based on the items.
The following items have classiness points associated
with them:
"tophat" = 2
"bowtie" = 4
"monocle" = 5
Everything else has 0 points.
Use the test cases below to guide you!"""


from msilib.schema import Error


class Classy(object):

    dict = {"tophat": 2, "bowtie": 4, "monocle": 5}

    classiness = 0

    def __init__(self):
        self.items = []

    def addItem(self, name):
        try:
            self.classiness = self.classiness + self.dict[name]
        except:
            pass

    def getClassiness(self):
        return self.classiness


# Test cases
me = Classy()

# Should be 0
print(me.getClassiness())

me.addItem("tophat")
# Should be 2
print(me.getClassiness())

me.addItem("bowtie")
me.addItem("jacket")
me.addItem("monocle")
# Should be 11
print(me.getClassiness())

me.addItem("bowtie")
# Should be 15
print(me.getClassiness())
