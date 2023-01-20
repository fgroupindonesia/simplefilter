
#How To use?

1. import the Jar under dist\SimpleFilter.jar
2. use with ease as the following examples


## Quick -01-
You have the jcombobox, and the jtable. So, let initialize 'em all with :

```
// 1st example for a simple one
SimpleFilter sf = new SimpleFilter(true);
sf.setFilterComponent(combobox);
sf.setTable(myJTable);
```

# preview
check the demo below:



## Quick -02-
You have several jcomboboxes, and the jtable. So, let initialize 'em too :

```
// now as 2nd example with column positioning
SimpleFilter sf = new SimpleFilter(true);
sf.setFilterComponents(combobox1, combobox2);
// matching the position of each column for each comboboxonly
sf.setColumnPositionRef(1, 3);
sf.setTable(myJTable);  
```

# screenshot
take a look of the position here:
[Preview #02](preview/example02.png)


# preview
check the demo below: