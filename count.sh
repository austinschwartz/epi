totals=(15 26 14 19 15 17 10 16 18 17 22 16 23 14 12 14 16)
chapters=(05 06 07 08 09 10 11 12 13 14 15 16 17 18 19 20 21)
name=README.txt
rm ${name}
echo "Elements of Programming Interviews problems\n" >> ${name}
for (( i=0; i<=16; i++  ))
do
  x=`echo */* | tr " " "\n" | grep -E "(ch${chapters[$i]}.*)" | wc -l | bc`
  echo "ch${chapters[$i]} - ${x} / ${totals[$i]}" >> ${name}
done


total=0
for i in ${totals[@]}; do
  let total+=$i
done

echo "\nTotal" >> ${name}
echo */* | tr ' ' '\n' | wc -l | bc | tr -d "\n" >> ${name}
echo " / ${total} problems\n" >> ${name}

cat ${name}
