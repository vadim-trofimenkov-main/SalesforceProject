#!/bin/bash

NODE_TOTAL=${CIRCLE_NODE_TOTAL:-1}
NODE_INDEX=${CIRCLE_NODE_INDEX:-0}

i=0
tests=()
for file in $(find ./src/test/java/com/itechart/tests -name "*Test.java" | sort)
do
  if [ $(($i % ${NODE_TOTAL})) -eq ${NODE_INDEX} ]
  then
    test=`basename $file | sed -e "s/.java//"`
    tests+="${test},"
  fi
  ((i++))
done

mvn mvn -Dtest=${tests} -Dmaven.test.failure.ignore=true test > build_status.log | egrep "^\[INFO\] Failures: [0-9]+$" | egrep -o '[0-9]+' | awk '{n += $1}; END{print n}'
echo $(( $(cat maven_build.out | grep "Failures" | grep -v "Time elapsed" | cut -d , -f 1 | cut -d " " -f 3 | tr "\n" "+") 0))
grep -oP '(?<=Failures: )[0-9]+' file