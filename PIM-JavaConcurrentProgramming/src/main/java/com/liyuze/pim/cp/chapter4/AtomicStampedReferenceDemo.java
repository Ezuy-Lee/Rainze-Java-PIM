package com.liyuze.pim.cp.chapter4;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Created by 13 on 2017/5/6.
 */
public class AtomicStampedReferenceDemo {
    static AtomicStampedReference<Integer> money = new AtomicStampedReference<Integer>(19, 0);

    public static void main(String args[]) {

        for (int i = 0; i < 100; i++) {
            final int timestap = money.getStamp();
            new Thread() {
                public void run() {
                    while (true) {
                        Integer m = money.getReference();
                        if (m < 20) {
                            if (money.compareAndSet(m, m + 20, timestap, timestap + 1)) {
                                System.out.println("���С��20Ԫ,��ֵ�ɹ�,���:" + money.getReference() + "Ԫ");
                                break;
                            }
                        } else {
                            System.out.println("������20,�����ֵ");
                            break;
                        }
                    }
                }
            }.start();
        }

        new Thread() {
            public void run() {
                for (int i = 0; i < 100; i++) {

                    while (true) {
                        int timestap = money.getStamp();
                        Integer m = money.getReference();
                        if (m > 10) {
                            System.out.println("������10Ԫ");
                            if (money.compareAndSet(m, m - 10, timestap, timestap + 1)) {
                                System.out.println("�ɹ�����10Ԫ,���:" + money.getReference() + "Ԫ");
                                break;
                            }
                        } else {
                            System.out.println("û���㹻�Ľ��");
                            break;
                        }
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

    }
}
