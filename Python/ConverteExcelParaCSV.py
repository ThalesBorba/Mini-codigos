import panda as pd
read_file = pd.read_excel("Test.xlsx")
read_file.to_csv("Test.csv", index=None, header=True)
dataframe_object = pd.DataFrame(pd.read_csv("Test.csv"))