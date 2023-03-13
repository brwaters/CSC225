#!/bin/bash
for i in {00..15};
    do
        cat ./input/input$i.txt | java ArrayMatch | diff ./output/output$i.txt - >/dev/null
        if [ $? -eq 0 ]; then
            echo "Test $i was successful!";
        else
            echo "Test $i failed";
        fi
done
