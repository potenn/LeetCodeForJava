/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

class Solution{

  public List<Interval> merge(List<Interval> intervals) {

    if(intervals == null || intervals.size() == 0){
      return new ArrayList<Interval>();
    }

    List<Interval> answerList = new ArrayList<Interval>();

    Collections.sort(intervals,new Comparator<Interval>(){
      public int compare(Interval o1, Interval o2){
        return o1.start - o2.start;
      }
    });

    int start = intervals.get(0).start;
    int end = intervals.get(0).end;

    for(Interval interval : intervals){

      if(interval.start <= end){
        end = Math.max(end, interval.end);
      }else{
        answerList.add(new Interval(start,end));
        start = interval.start;
        end = interval.end;
      }
    }
    answerList.add(new Interval(start,end));
    return answerList;
  }

}
