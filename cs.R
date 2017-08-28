rm(list=ls())
setwd("C:/Users/USER/Desktop/2nd year/2nd Semester/CSC2002S/Assignments/Assignment1")
getwd()
cscData <-read.csv("sequentialCutOffAll.csv")
min(as.numeric(cscData$Time))
max(as.numeric(cscData$Time))
cscData[cscData$Time==min(as.numeric(cscData$Time)),]
cscData[cscData$Time==max(as.numeric(cscData$Time)),]
median(as.numeric(cscData$Time))
boxplot(cscData$Time)

