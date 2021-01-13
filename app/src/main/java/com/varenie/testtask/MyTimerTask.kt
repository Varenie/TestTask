package com.varenie.testtask

import java.util.*
import kotlin.collections.ArrayList

class MyTimerTask(val list: ArrayList<Int>, val deletedItems: ArrayList<Int>): TimerTask() {

    override fun run() {
//       если массив удаленных элементов пуст, добавляются новые элементы, если нет, элементы берутся из удаленных
        if (deletedItems.isEmpty()) {
            list.add(list.size + 1)
        } else {
//          добавляется первый элемент из списка удаленных
            list.add(deletedItems[0])
            deletedItems.removeAt(0)
        }
    }
}
