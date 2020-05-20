package algorithm.leetcode;

import algorithm.onlineassesment.amazon.Maze;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxPointFromCardsTest {
    MaxPointFromCards maxPointFromCards = new MaxPointFromCards();
    @Test
    void maxScore() {
        int[] cardPoints = {1,2,3,4,5,6,1};
        int k = 3;
        int expected = 12;
        int actual = maxPointFromCards.maxScore(cardPoints, k);
        Assert.assertEquals(expected, actual);
    }

    @Test
    void maxScore1() {
        int[] cardPoints = {2,2,2};
        int k = 2;
        int expected = 4;
        int actual = maxPointFromCards.maxScore(cardPoints, k);
        Assert.assertEquals(expected, actual);
    }


    @Test
    void maxScore2() {
        int[] cardPoints = {9,7,7,9,7,7,9};
        int k = 7;
        int expected = 55;
        int actual = maxPointFromCards.maxScore(cardPoints, k);
        Assert.assertEquals(expected, actual);
    }

    @Test
    void maxScore3() {
        int[] cardPoints = {1,1000,1};
        int k = 1;
        int expected =1;
        int actual = maxPointFromCards.maxScore(cardPoints, k);
        Assert.assertEquals(expected, actual);
    }

    @Test
    void maxScore4() {
        int[] cardPoints = {1,79,80,1,1,1,200,1};
        int k = 3;
        int expected =202;
        int actual = maxPointFromCards.maxScore(cardPoints, k);
        Assert.assertEquals(expected, actual);
    }
//[937,985,98,828,839,23,470,109,644,645,881,218,929,811,677,960,792,188,561,643,534,904,571,914,733,78,887,803,227,266,409,910,37,314,296,528,466,193,176,330,2,337,615,659,193,900,966,748,862,362,369,396,954,83,879,553,613,46,657,748,388,960,328,115,481,985,118,511,821,588,597,70,550,693,889,289,255,139,245,71,166,137,941,859,199,137,830,652,219,516,335,450,584,811,818,890,625,914,196,362,906,545,471,766,448,446,679,930,683,791,373,192,478,415,448,857,693,943,647,50,863,348,736,860,784,690,943,232,612,550,477,775,822,75,914,978,963,59,402,267,691,769,635,404,979,104,249,15,950,105,658,654,357,793,329,450,721,76,220,503,838,700,266,751,656,189,421,213,541,997,742,181,843,373,235,130,182,12,681,537,482,497,716,613,4,22,486,389,344,105,765,690,376,435,331,946,386,800,759,11,754,70,668,428,79,152,428,140,41,256,669,362,697,838,425,697,986,731,270,231,265,181,838,287,798,869,519,406,486,770,843,122,24,354,119,307,272,93,154,796,700,553,137,248,60,440,21,486,645,635,256,659,498,127,503,314,219,927,300,804,374,313,411,597,768,594,167,390,777,348,599,859,260,128,394,157,280,785,833,393,544,2,913,494,33,145,111,155,45,242,209,561,963,785,654,888,74,397,798,609,207,766,530,939,977,3,887,278,601,624,926,273,367,437,239,201,186,199,306,86,253,419,612,39,160,596,198,171,2,456,717,396,422,823,856,884,998,93,578,523,36,331,504,926,289,637,829,444,792,861,17,661,377,228,472,46,792,913,343,408,531,753,841,588,224,330,71,738,326,360,791,812,719,107,982,918,402,78,860,142,740,967,715,704,445,836,212,271,816,822,891,470,903,854,281,519,710,224,853,898,501,111,287,105,985,619,532,753,425,819,20,410,822,467,859,823,211,767,171,405,208,740,517,312,892,415,311,812,803,203,785,353,279,767,598,291,873,902,337,550,133,69,502,236,437,564,329,577,693,625,5,476,613,523,340,806,235,111,572,357,226,634,260,650,150,861,502,310,567,784,418,840,628,381,541,115,904,185,364,360,334,740,277,114,676,426,862,749,158,773,741,790,95,603,411,503,760,609,577,139,633,70,740,225,903,191,255,831,658,467,352,339,82,39,784,65,406,59,88,799,105,128,44,599,215,60,175,12,512,188,290,103,587,63,454,891,380,516,834,541,707,704,797,821,888,106,414,96,786,767,946,824,140,858,937,377,948,971,831,351,573,231,707,793,481,393,850,112,778,202,733,591,364,751,525,341,799,872,479,823,634,510,259,485,9,180,723,916,457,305,921,219,862,243,879,614,984,81,23,412,743,317,649,819,965,458,926,794,20,948,231,882,244,410,233,771,803,782,981,371,748,92,913,858,833,471,173,432,522,303,864,119,127,226,68,1,593,286,113,137,162,503,603,720,944,754,374,215,406,460,22,576,679,847,209,119,433,242,958,529,662,610,562,853,797,915,237,265,402,372,53,531,975,153,756,255,793,985,684,239,922,946,906,674,629,194,749,274,625,876,537,860,644,842,638,96,516,508,876,208,377,945,990,888,329,1,142,673,980,743,996,859,310,377,830,347,870,150,216,563,857,858,909,298,223,489,469,985,659,272,4,955,469,44,566,67,498,185,23,737,853,773,948,891,809,972,360,235,228,366,781,541,176,714,594,150,845,310,289,530,584,806,185,642,841,459,90,1000,466,518,338,954,340,168,338,363,728,576,284,388,226,316,89,478,510,399,527,139,911,621,446,455,443,854,369,131,836,381,53,426,832,312,644,762,868,106,539,781,848,231,410,954,457,966,722,389,220,911,738,495,610,479,535,956,861,148,820,486,21,213,643,58,728,411,583,626,310,701,600,606,107,734,601,398,815,824,73,138,976,999,734,543,687,790,439,232,163,936,627,140,575,697,287,854,617,21,103,882,592,277,448,579,257,570,734,471,601,46,559,99,359,586,171,654,565,225,265,732,763,860,39,802,917,845,62,421,392,155,172,553,755,358,804,942,654,348,602,102,159,110,953,209,655,263,559,664,22,175,914,78,420,449,923,77,419,628,382,342,536,61,712,58,545,730,526,352,313,666,266,360,391,147,69,585,106,783,954,45,334,624,483,98,419,720,565,203,552,781,568,559,239,124,817,85,498,593,63,147,789,610,521,452,116,371,566,983,675,718,906,98,859,694,977,612,57,380,530,860,302,217,373,267,995,889,510,949,162,157,908,381,601,322,805,553,246,941,417,599,478,829,531,786,847,766,566,347,84,173,132,989,452,435,830,401,315,641,339,822,381,504,813,287,370,677,2,633,131,237,83,748,709,33,775,859,663,304,587,953,185,548,603,646,784,208,8,124,29,170,88,451,365,259,656,780,370,853,175,878,380,865,82,756,724,955,701,373,149,458,485,6,358,823,871,851,179,220,286,463,223,598,716,763,102,620,452,94,618,110,328,35,765,601,731,218,765,445,600,336,954,744,459,362,369,627,347,332,768,6,622,94,887,219,355,239,322,14,564,451,371,232,655,243,379,577,659,580,450,316,619,362,533,467,354,32,965,570,121,523,744,225,756,350,357,734,762,539,389,493,430,543,296,153,378,10,723,806,108,40,622,807,144,862,950,248,158,676,431,694,523,180,942,269,327,396,300,558,972,65,613,813,571,676,4,464,191,103,98,773,770,830,136,906,670,314,475,678,826,678,323,584,175,372,744,907,179,372,901,195,52,871,702,387,244,484,55,775,364,997,268,510,875,470,967,265,830,250,158,668,68,477,199,572,413,871,796,789,561,532,225,137,312,39,677,278,276,598,863,997,371,625,521,279,441,324,677,779,943,763,786,951,634,685,325,664,935,188,213,12,531,414,982,547,857,509,817,246,155,290,988,277,390,27,848,375,727,68,520,583,458,674,570,219,556,163,278,686,175,450,164,618,817,168,797,257,972,885,274,131,571,745,336,704,427,647,694,760,478,508,943,723,815,256,763,909,262,370,644,558,611,704,324,397,603,66,701,956,114,834,12,902,385,498,896,122,458,30,197,910,739,313,319,760,852,875,847,336,695,469,718,840,168,791,122,885,78,947,457,151,405,71,88,585,730,958,639,727,515,646,917,215,726,354,35,904,798,190,703,189,252,541,8,387,578,154,109,839,478,861,498,148,654,284,820,477,831,180,833,161,223,610,630,882,509,636,498,478,584,410,845,82,259,340,945,639,374,263,791,343,708,571,373,69,38,45,881,127,278,942,522,405,811,585,17,534,532,175,504,76,219,813,446,789,599,97,586,91,665,510,299,286,167,13,143,485,585,523,149,716,317,262,887,563,310,618,651,362,239,831,908,147,298,945,453,869,460,736,432,971,272,148,541,711,585,135,112,513,986,345,320,56,563,287,389,455,40,579,735,790,995,14,626,777,286,7,920,755,830,132,730,34,622,315,285,294,846,645,623,390,616,713,11,208,374,699,281,507,275,576,726,225,67,260,799,924,478,261,811,7,475,152,769,305,722,632,53,576,394,777,310,669,139,340,285,441,792,397,202,948,958,925,690,727,634,704,264,329,326,549,610,341,388,644,505,261,816,753,629,14,49,883,730,857,918,496,545,112,405,198,877,949,16,19,187,772,5,869,419,754,80,575,806,443,87,592,410,466,862,338,799,585,399,168,797,534,218,995,925,606,221,667,576,660,107,649,585,378,11,366,285,119,323,110,848,473,471,472,648,85,354,260,285,761,337,461,1000,788,361,673,972,209,712,604,802,778,302,912,5,46,227,898,635,572,854,579,660,11,561,430,632,168,638,573,177,232,599,586,858,412,91,323,118,968,415,494,894,782,768,465,980,614,672,560,61,727,936,182,805,819,145,702,303,287,832,170,67,794,172,449,109,670,521,383,938,471,495,699,114,475,281,677,392,315,944,799,684,633,256,336,337,84,866,915,471,45,106,330,574,314,712,281,518,120,757,873,672,891,535,618,194,347,638,727,68,283,280,432,952,115,953,449,104,178,805,416,486,586,157,192,810,971,132,421,661,845,914,276,599,973,474,719,410,799,876,539,606,863,663,296,189,688,898,724,356,787,688,704,224,888,716,209,188,424,312,464,603,265,951,832,780,565,53,207,533,40,217,378,90,262,947,448,883,478,218,928,850,225,262,94,605,69,339,525,568,849,983,835,138,193,969,826,5,225,447,474,854,939,853,269,505,211,169,676,216,591,949,678,230,71,940,327,606,239,903,386,514,28,570,136,434,454,493,372,277,703,280,319,710,243,94,472,174,216,861,784,843,980,726,408,129,299,578,171,628,803,197,980,193,320,548,901,465,679,456,497,561,676,575,149,156,969,156,740,924,839,803,416,450,551,422,178,88,258,242,435,159,652,814,464,622,476,276,69,907,969,970,237,148,55,398,893,737,265,411,183,690,976,24,747,433,433,337,224,705,468,960,369,398,935,68,360,514,227,270,95,535,236,968,338,652,784,495,84,481,974,214,237,49,571,835,340,334,48,198,754,342,84,678,747,379,32,947,65,330,314,603,824,352,266,88,392,585,865,115,660,241,199,372,727,309,803,971,303,110,958,458,820,859,288,297,730,817,26,100,869,36,908,529,193,217,644,104,675,156,548,496,145,671,857,985,700,24,787,858,403,117,521,36,255,570,704,684,811,601,70,730,740,333,631,311,253,43,263,638,857,533,786,822,401,369,533,198,816,138,749,482,336,102,362,837,735,566,69,729,616,951,484,95,667,864,708,611,966,227,802,194,379,444,409,753,36,856,498,291,903,171,108,707,326,680,790,246,296,862,692,292,178,310,188,574,759,795,681,345,685,263,152,992,335,994,754,634,140,687,999,278,208,917,196,36,914,343,93,531,317,906,379,185,53,226,962,427,934,474,929,611,606,297,447,546,150,94,119,720,37,533,706,994,979,472,801,365,566,276,792,116,690,537,716,419,992,111,638,845,81,897,793,678,792,291,267,838,369,415,315,600,854,701,174,685,447,306,198,236,733,107,646,363,132,418,137,875,183,565,470,40,687,310,347,789,84,205,571,866,623,364,678,181,60,882,509,82,767,669,607,98,874,514,242,1000,492,509,862,99,824,938,338,543,196,605,915,589,354,854,949,265,816,229,147,969,894,807,102,299,923,734,430,738,579,131,359,974,773,994,529,911,466,282,369,453,950,988,522,488,890,227,510,522,200,119,263,412,936,328,184,492,854,486,611,838,456,529,258,988,904,447,2,764,49,120,108,580,388,744,602,282,997,487,474,668,448,656,704,705,477,28,28,686,392,280,765,79,30,883,459,786,619,376,605,685,100,924,864,74,920,393,549,948,820,716,626,235,779,895,612,365,16,328,224,198,545,204,178,479,313,35,561,375,227,673,950,559,653,886,593,892,4,975,77,557,937,848,92,557,220,871,445,105,175,4,990,517,138,188,166,522,935,456,71,308,445,945,697,159,506,351,781,44,261,838,48,611,229,826,934,23,994,271,323,402,461,826,195,737,1000,124,195,910,4,127,306,820,871,976,192,892,440,497,521,545,120,920,763,572,877,691,467,529,283,979,114,617,858,383,202,376,344,733,773,442,943,185,90,753,475,738,17,568,159,158,981,764,284,506,329,304,721,305,799,616,350,367,776,816,933,104,903,516,780,245,305,522,929,549,548,209,376,297,454,431,567,722,616,336,720,960,218,703,372,403,226,577,426,548,532,184,469,766,89,749,329,734,788,892,601,817,257,720,992,386,806,786,192,596,252,870,928,708,505,733,965,527,10,393,310,113,943,370,557,587,893,886,122,834,551,337,785,339,731,39,425,34,830,597,694,888,900,592,858,515,308,637,83,567,928,773,849,255,711,911,711,413,957,452,108,576,257,530,460,405,869,178,709,770,874,408,476,441,138,845,502,402,2,813,608,827,307,393,827,212,703,769,427,195,695,740,759,390,697,786,236,177,489,658,209,137,85,466,148,309,559,28,603,766,895,234,960,686,163,442,376,709,325,606,47,73,691,437,266,986,970,171,466,442,142,65,950,62,734,985,418,848,192,58,454,400,270,164,18,340,173,734,1000,677,866,455,176,741,837,603,762,768,450,134,120,309,765,65,222,988,455,383,461,328,970,630,845,747,395,850,544,261,869,290,612,12,853,382,114,548,581,878,469,596,590,773,653,445,126,55,53,14,844,399,363,913,314,742,497,536,192,147,231,662,130,223,10,737,660,380,348,800,60,969,807,220,919,781,458,795,311,441,609,841,455,978,220,582,348,1,549,105,481,205,773,936,739,369,235,978,178,822,312,65,556,259,122,684,398,210,318,738,155,952,345,189,419,819,340,828,367,762,712,387,860,376,750,102,530,898,731,664,204,544,107,892,831,851,335,897,407,851,357,268,305,157,35,185,808,682,120,882,683,561,567,293,344,719,430,986,771,654,173,485,301,193,546,479,141,357,36,957,549,891,168,221,167,75,321,189,615,895,89,452,140,44,417,136,512,540,754,505,589,309,649,302,428,339,980,814,741,122,172,582,236,668,794,643,582,105,663,866,592,495,417,840,746,173,843,930,783,828,661,50,572,896,509,902,54,908,718,576,14,324,554,730,165,372,933,895,951,402,63,469,482,396,520,40,820,403,493,846,710,635,612,333,688,239,56,460,160,76,545,734,748,809,481,370,601,176,583,340,289,374,216,81,647,712,60,581,557,423,480,600,402,265,278,744,72,159,712,998,947,647,980,690,478,105,266,967,784,321,966,937,596,711,758,850,801,702,536,115,621,847,477,754,285,925,814,804,452,569,909,621,327,510,511,678,175,990,408,169,623,878,422,199,161,137,855,543,190,691,483,423,705,474,898,337,832,190,169,811,415,211,259,585,191,628,763,36,951,732,261,833,388,432,333,946,300,487,613,390,884,947,382,648,452,97,420,717,650,897,709,893,932,537,224,385,69,609,678,812,787,506,271,685,673,430,398,998,272,139,451,30,989,110,304,131,286,877,821,117,973,868,142,617,187,326,833,755,334,777,370,330,159,409,32,103,123,724,708,396,48,383,1000,335,920,661,448,260,68,413,744,930,38,151,658,108,415,32,776,480,692,505,946,912,185,271,99,788,889,555,76,379,266,603,84,126,991,545,817,440,903,540,281,721,114,366,613,142,710,238,755,740,514,73,413,771,599,619,604,801,770,441,642,313,143,511,753,448,646,568,403,519,588,601,299,737,631,457,645,263,227,969,949,68,151,418,458,46,159,189,505,764,896,892,373,890,126,165,408,155,310,31,251,993,263,179,467,201,799,462,857,779,511,371,93,728,174,470,18,200,739,60,235,970,474,483,952,14,741,977,909,381,893,94,960,365,314,639,554,541,313,871,227,976,290,167,895,308,737,196,721,302,955,293,848,355,477,43,873,971,258,791,309,970,133,89,467,19,345,374,95,103,498,318,199,430,732,600,923,461,716,279,146,268,606,500,960,530,923,635,880,12,567,665,753,879,387,162,806,447,342,39,589,760,782,702,937,164,16,762,314,913,77,120,889,765,550,430,216,280,887,977,991,635,23,976,638,995,247,706,947,41,67,448,586,7,715,925,295,22,102,235,321,730,863,487,61,377,582,922,492,143,62,421,970,540,153,835,158,936,266,680,65,172,591,811,262,340,978,469,335,78,581,589,987,457,807,606,273,536,96,692,48,720,623,139,824,61,160,966,450,173,287,413,651,850,409,869,463,491,269,315,257,865,357,903,737,226,722,909,594,926,516,761,816,628,20,611,766,660,687,75,427,180,406,108,237,111,504,214,811,205,250,72,396,893,774,135,893,860,266,240,413,606,672,592,389,713,383,161,409,926,930,489,261,929,222,233,745,468,472,345,207,31,303,960,739,743,849,834,743,564,366,573,53,664,892,763,425,106,132,536,482,557,827,123,838,922,726,870,643,457,283,961,707,993,451,309,686,126,174,32,268,367,666,3,445,804,631,262,197,881,894,394,60,734,726,646,109,644,340,817,212,816,857,74,709,145,919,344,814,225,379,219,365,958,397,30,149,820,756,317,991,298,715,497,939,871,918,10,67,663,135,523,1,210,852,784,267,250,644,871,90,705,132,842,428,472,436,671,621,735,460,205,417,790,784,179,282,215,747,624,561,540,749,441,915,92,370,844,612,577,155,226,610,698,509,608,581,756,335,840,659,169,941,896,371,587,723,183,720,463,124,499,876,114,530,494,447,280,831,310,947,182,9,824,432,540,61,216,502,559,936,402,5,208,683,713,993,888,103,111,709,339,542,815,740,73,110,542,454,351,863,314,378,762,413,835,108,179,798,960,511,781,913,28,201,370,825,294,97,828,625,604,415,417,785,934,650,574,38,539,53,930,945,694,114,388,484,914,571,638,552,537,6,469,199,740,390,13,712,169,966,158,375,490,9,181,527,398,866,564,134,591,613,591,910,376,473,547,975,706,470,204,543,805,899,591,899,294,940,464,81,532,175,413,561,679,421,907,45,677,608,192,608,466,171,745,655,382,848,999,257,600,126,701,703,227,535,572,859,648,285,909,549,882,295,19,858,543,107,736,808,374,23,452,77,124,644,517,674,373,902,565,513,331,629,820,438,318,139,429,189,211,377,288,35,30,443,529,597,948,677,343,309,681,937,199,181,677,527,583,489,154,60,367,351,367,672,358,915,513,841,414,87,282,262,594,617,368,568,778,719,871,537,383,184,355,397,637,79,632,987,57,443,216,775,126,937,717,305,659,260,385,791,724,170,585,984,153,702,197,353,830,692,355,16,837,774,260,515,99,729,502,562,362,196,815,246,413,296,249,574,828,713,994,921,239,691,14,257,245,673,541,309,209,268,823,474,377,889,852,26,909,94,615,730,383,878,700,178,433,514,580,545,743,26,69,576,435,809,709,385,280,345,951,217,618,701,129,363,324,73,525,703,754,675,7,369,166,823,315,941,292,629,779,495,55,549,520,729,157,70,268,984,138,681,180,534,899,862,434,135,995,806,706,272,242,497,299,713,697,895,137,126,785,630,840,969,782,269,847,784,450,244,4,68,213,633,892,257,143,822,556,428,177,338,415,381,287,772,157,789,501,347,373,556,949,982,836,861,803,56,703,833,968,158,75,940,86,294,778,282,833,574,805,573,340,53,942,881,665,203,160,334,438,786,458,946,563,477,343,120,768,948,839,823,70,72,130,302,196,355,894,768,993,236,328,810,388,656,58,110,900,397,134,955,74,993,173,231,750,366,484,280,889,385,434,315,606,294,531,552,177,738,546,398,502,299,671,738,223,127,195,764,505,276,310,928,589,481,868,165,223,336,605,808,7,659,95,661,346,770,278,65,332,534,126,514,229,929,15,114,281,31,951,288,408,846,137,601,696,536,588,587,183,800,643,504,977,621,864,94,425,806,630,449,565,967,693,75,819,94,649,761,117,639,905,18,109,599,347,842,89,199,226,466,497,952,8,405,445,444,730,977,750,725,351,338,469,84,499,876,102,651,592,731,217,552,980,308,799,594,514,703,890,526,478,148,382,646,633,460,624,531,115,784,739,954,486,517,134,509,422,646,103,247,165,597,783,843,370,816,845,445,795,942,638,517,475,868,808,239,967,897,55,382,264,942,294,922,622,271,151,550,482,28,812,536,602,74,288,753,816,591,112,18,262,974,92,86,950,80,878,341,804,772,84,687,798,878,62,174,907,878,242,707,82,883,270,544,926,496,717,470,509,399,849,59,704,464,874,487,666,730,89,193,123,221,106,14,782,638,412,278,736,296,295,685,406,480,254,579,281,961,911,907,62,548,840,974,709,712,583,49,954,492,347,377,782,769,645,413,846,993,61,144,961,287,796,702,881,936,681,721,154,58,291,889,552,89,716,546,394,193,20,162,835,138,547,678,414,708,135,622,488,706,528,661,638,273,306,893,567,98,206,776,993,696,744,90,18,954,496,707,682,666,310,424,672,416,497,617,327,273,653,627,764,341,679,983,780,46,72,512,42,233,79,730,507,427,258,212,147,354,187,755,502,625,237,487,461,717,135,45,939,631,228,931,311,67,119,400,569,465,707,38,703,410,61,328,477,389,457,854,106,212,564,893,189,889,248,552,616,816,875,585,710,245,511,189,660,319,614,507,671,704,551,445,492,906,701,781,137,393,742,514,428,947,593,915,300,342,708,705,228,359,537,570,281,436,115,73,245,709,591,822,167,880,54,846,289,15,475,106,78,713,271,646,953,350,865,766,333,337,153,922,743,562,287,582,45,841,346,752,215,246,548,232,46,830,335,64,812,395,632,605,122,914,903,958,326,647,824,507,605,760,313,361,632,642,837,970,604,527,680,264,34,215,756,676,502,592,663,709,85,311,687,608,670,409,271,688,743,421,420,117,55,578,156,635,568,487,174,840,282,207,211,809,19,290,368,829,394,721,738,650,427,196,430,119,936,497,359,105,845,1000,825,116,907,494,348,521,179,870,566,582,530]
//1957

    @Test
    void maxScore5() {
        int[] cardPoints = {937,985,98,828,839,23,470,109,644,645,881,218,929,811,677,960,792,188,561,643,534,904,571,914,733,78,887,803,227,266,409,910,37,314,296,528,466,193,176,330,2,337,615,659,193,900,966,748,862,362,369,396,954,83,879,553,613,46,657,748,388,960,328,115,481,985,118,511,821,588,597,70,550,693,889,289,255,139,245,71,166,137,941,859,199,137,830,652,219,516,335,450,584,811,818,890,625,914,196,362,906,545,471,766,448,446,679,930,683,791,373,192,478,415,448,857,693,943,647,50,863,348,736,860,784,690,943,232,612,550,477,775,822,75,914,978,963,59,402,267,691,769,635,404,979,104,249,15,950,105,658,654,357,793,329,450,721,76,220,503,838,700,266,751,656,189,421,213,541,997,742,181,843,373,235,130,182,12,681,537,482,497,716,613,4,22,486,389,344,105,765,690,376,435,331,946,386,800,759,11,754,70,668,428,79,152,428,140,41,256,669,362,697,838,425,697,986,731,270,231,265,181,838,287,798,869,519,406,486,770,843,122,24,354,119,307,272,93,154,796,700,553,137,248,60,440,21,486,645,635,256,659,498,127,503,314,219,927,300,804,374,313,411,597,768,594,167,390,777,348,599,859,260,128,394,157,280,785,833,393,544,2,913,494,33,145,111,155,45,242,209,561,963,785,654,888,74,397,798,609,207,766,530,939,977,3,887,278,601,624,926,273,367,437,239,201,186,199,306,86,253,419,612,39,160,596,198,171,2,456,717,396,422,823,856,884,998,93,578,523,36,331,504,926,289,637,829,444,792,861,17,661,377,228,472,46,792,913,343,408,531,753,841,588,224,330,71,738,326,360,791,812,719,107,982,918,402,78,860,142,740,967,715,704,445,836,212,271,816,822,891,470,903,854,281,519,710,224,853,898,501,111,287,105,985,619,532,753,425,819,20,410,822,467,859,823,211,767,171,405,208,740,517,312,892,415,311,812,803,203,785,353,279,767,598,291,873,902,337,550,133,69,502,236,437,564,329,577,693,625,5,476,613,523,340,806,235,111,572,357,226,634,260,650,150,861,502,310,567,784,418,840,628,381,541,115,904,185,364,360,334,740,277,114,676,426,862,749,158,773,741,790,95,603,411,503,760,609,577,139,633,70,740,225,903,191,255,831,658,467,352,339,82,39,784,65,406,59,88,799,105,128,44,599,215,60,175,12,512,188,290,103,587,63,454,891,380,516,834,541,707,704,797,821,888,106,414,96,786,767,946,824,140,858,937,377,948,971,831,351,573,231,707,793,481,393,850,112,778,202,733,591,364,751,525,341,799,872,479,823,634,510,259,485,9,180,723,916,457,305,921,219,862,243,879,614,984,81,23,412,743,317,649,819,965,458,926,794,20,948,231,882,244,410,233,771,803,782,981,371,748,92,913,858,833,471,173,432,522,303,864,119,127,226,68,1,593,286,113,137,162,503,603,720,944,754,374,215,406,460,22,576,679,847,209,119,433,242,958,529,662,610,562,853,797,915,237,265,402,372,53,531,975,153,756,255,793,985,684,239,922,946,906,674,629,194,749,274,625,876,537,860,644,842,638,96,516,508,876,208,377,945,990,888,329,1,142,673,980,743,996,859,310,377,830,347,870,150,216,563,857,858,909,298,223,489,469,985,659,272,4,955,469,44,566,67,498,185,23,737,853,773,948,891,809,972,360,235,228,366,781,541,176,714,594,150,845,310,289,530,584,806,185,642,841,459,90,1000,466,518,338,954,340,168,338,363,728,576,284,388,226,316,89,478,510,399,527,139,911,621,446,455,443,854,369,131,836,381,53,426,832,312,644,762,868,106,539,781,848,231,410,954,457,966,722,389,220,911,738,495,610,479,535,956,861,148,820,486,21,213,643,58,728,411,583,626,310,701,600,606,107,734,601,398,815,824,73,138,976,999,734,543,687,790,439,232,163,936,627,140,575,697,287,854,617,21,103,882,592,277,448,579,257,570,734,471,601,46,559,99,359,586,171,654,565,225,265,732,763,860,39,802,917,845,62,421,392,155,172,553,755,358,804,942,654,348,602,102,159,110,953,209,655,263,559,664,22,175,914,78,420,449,923,77,419,628,382,342,536,61,712,58,545,730,526,352,313,666,266,360,391,147,69,585,106,783,954,45,334,624,483,98,419,720,565,203,552,781,568,559,239,124,817,85,498,593,63,147,789,610,521,452,116,371,566,983,675,718,906,98,859,694,977,612,57,380,530,860,302,217,373,267,995,889,510,949,162,157,908,381,601,322,805,553,246,941,417,599,478,829,531,786,847,766,566,347,84,173,132,989,452,435,830,401,315,641,339,822,381,504,813,287,370,677,2,633,131,237,83,748,709,33,775,859,663,304,587,953,185,548,603,646,784,208,8,124,29,170,88,451,365,259,656,780,370,853,175,878,380,865,82,756,724,955,701,373,149,458,485,6,358,823,871,851,179,220,286,463,223,598,716,763,102,620,452,94,618,110,328,35,765,601,731,218,765,445,600,336,954,744,459,362,369,627,347,332,768,6,622,94,887,219,355,239,322,14,564,451,371,232,655,243,379,577,659,580,450,316,619,362,533,467,354,32,965,570,121,523,744,225,756,350,357,734,762,539,389,493,430,543,296,153,378,10,723,806,108,40,622,807,144,862,950,248,158,676,431,694,523,180,942,269,327,396,300,558,972,65,613,813,571,676,4,464,191,103,98,773,770,830,136,906,670,314,475,678,826,678,323,584,175,372,744,907,179,372,901,195,52,871,702,387,244,484,55,775,364,997,268,510,875,470,967,265,830,250,158,668,68,477,199,572,413,871,796,789,561,532,225,137,312,39,677,278,276,598,863,997,371,625,521,279,441,324,677,779,943,763,786,951,634,685,325,664,935,188,213,12,531,414,982,547,857,509,817,246,155,290,988,277,390,27,848,375,727,68,520,583,458,674,570,219,556,163,278,686,175,450,164,618,817,168,797,257,972,885,274,131,571,745,336,704,427,647,694,760,478,508,943,723,815,256,763,909,262,370,644,558,611,704,324,397,603,66,701,956,114,834,12,902,385,498,896,122,458,30,197,910,739,313,319,760,852,875,847,336,695,469,718,840,168,791,122,885,78,947,457,151,405,71,88,585,730,958,639,727,515,646,917,215,726,354,35,904,798,190,703,189,252,541,8,387,578,154,109,839,478,861,498,148,654,284,820,477,831,180,833,161,223,610,630,882,509,636,498,478,584,410,845,82,259,340,945,639,374,263,791,343,708,571,373,69,38,45,881,127,278,942,522,405,811,585,17,534,532,175,504,76,219,813,446,789,599,97,586,91,665,510,299,286,167,13,143,485,585,523,149,716,317,262,887,563,310,618,651,362,239,831,908,147,298,945,453,869,460,736,432,971,272,148,541,711,585,135,112,513,986,345,320,56,563,287,389,455,40,579,735,790,995,14,626,777,286,7,920,755,830,132,730,34,622,315,285,294,846,645,623,390,616,713,11,208,374,699,281,507,275,576,726,225,67,260,799,924,478,261,811,7,475,152,769,305,722,632,53,576,394,777,310,669,139,340,285,441,792,397,202,948,958,925,690,727,634,704,264,329,326,549,610,341,388,644,505,261,816,753,629,14,49,883,730,857,918,496,545,112,405,198,877,949,16,19,187,772,5,869,419,754,80,575,806,443,87,592,410,466,862,338,799,585,399,168,797,534,218,995,925,606,221,667,576,660,107,649,585,378,11,366,285,119,323,110,848,473,471,472,648,85,354,260,285,761,337,461,1000,788,361,673,972,209,712,604,802,778,302,912,5,46,227,898,635,572,854,579,660,11,561,430,632,168,638,573,177,232,599,586,858,412,91,323,118,968,415,494,894,782,768,465,980,614,672,560,61,727,936,182,805,819,145,702,303,287,832,170,67,794,172,449,109,670,521,383,938,471,495,699,114,475,281,677,392,315,944,799,684,633,256,336,337,84,866,915,471,45,106,330,574,314,712,281,518,120,757,873,672,891,535,618,194,347,638,727,68,283,280,432,952,115,953,449,104,178,805,416,486,586,157,192,810,971,132,421,661,845,914,276,599,973,474,719,410,799,876,539,606,863,663,296,189,688,898,724,356,787,688,704,224,888,716,209,188,424,312,464,603,265,951,832,780,565,53,207,533,40,217,378,90,262,947,448,883,478,218,928,850,225,262,94,605,69,339,525,568,849,983,835,138,193,969,826,5,225,447,474,854,939,853,269,505,211,169,676,216,591,949,678,230,71,940,327,606,239,903,386,514,28,570,136,434,454,493,372,277,703,280,319,710,243,94,472,174,216,861,784,843,980,726,408,129,299,578,171,628,803,197,980,193,320,548,901,465,679,456,497,561,676,575,149,156,969,156,740,924,839,803,416,450,551,422,178,88,258,242,435,159,652,814,464,622,476,276,69,907,969,970,237,148,55,398,893,737,265,411,183,690,976,24,747,433,433,337,224,705,468,960,369,398,935,68,360,514,227,270,95,535,236,968,338,652,784,495,84,481,974,214,237,49,571,835,340,334,48,198,754,342,84,678,747,379,32,947,65,330,314,603,824,352,266,88,392,585,865,115,660,241,199,372,727,309,803,971,303,110,958,458,820,859,288,297,730,817,26,100,869,36,908,529,193,217,644,104,675,156,548,496,145,671,857,985,700,24,787,858,403,117,521,36,255,570,704,684,811,601,70,730,740,333,631,311,253,43,263,638,857,533,786,822,401,369,533,198,816,138,749,482,336,102,362,837,735,566,69,729,616,951,484,95,667,864,708,611,966,227,802,194,379,444,409,753,36,856,498,291,903,171,108,707,326,680,790,246,296,862,692,292,178,310,188,574,759,795,681,345,685,263,152,992,335,994,754,634,140,687,999,278,208,917,196,36,914,343,93,531,317,906,379,185,53,226,962,427,934,474,929,611,606,297,447,546,150,94,119,720,37,533,706,994,979,472,801,365,566,276,792,116,690,537,716,419,992,111,638,845,81,897,793,678,792,291,267,838,369,415,315,600,854,701,174,685,447,306,198,236,733,107,646,363,132,418,137,875,183,565,470,40,687,310,347,789,84,205,571,866,623,364,678,181,60,882,509,82,767,669,607,98,874,514,242,1000,492,509,862,99,824,938,338,543,196,605,915,589,354,854,949,265,816,229,147,969,894,807,102,299,923,734,430,738,579,131,359,974,773,994,529,911,466,282,369,453,950,988,522,488,890,227,510,522,200,119,263,412,936,328,184,492,854,486,611,838,456,529,258,988,904,447,2,764,49,120,108,580,388,744,602,282,997,487,474,668,448,656,704,705,477,28,28,686,392,280,765,79,30,883,459,786,619,376,605,685,100,924,864,74,920,393,549,948,820,716,626,235,779,895,612,365,16,328,224,198,545,204,178,479,313,35,561,375,227,673,950,559,653,886,593,892,4,975,77,557,937,848,92,557,220,871,445,105,175,4,990,517,138,188,166,522,935,456,71,308,445,945,697,159,506,351,781,44,261,838,48,611,229,826,934,23,994,271,323,402,461,826,195,737,1000,124,195,910,4,127,306,820,871,976,192,892,440,497,521,545,120,920,763,572,877,691,467,529,283,979,114,617,858,383,202,376,344,733,773,442,943,185,90,753,475,738,17,568,159,158,981,764,284,506,329,304,721,305,799,616,350,367,776,816,933,104,903,516,780,245,305,522,929,549,548,209,376,297,454,431,567,722,616,336,720,960,218,703,372,403,226,577,426,548,532,184,469,766,89,749,329,734,788,892,601,817,257,720,992,386,806,786,192,596,252,870,928,708,505,733,965,527,10,393,310,113,943,370,557,587,893,886,122,834,551,337,785,339,731,39,425,34,830,597,694,888,900,592,858,515,308,637,83,567,928,773,849,255,711,911,711,413,957,452,108,576,257,530,460,405,869,178,709,770,874,408,476,441,138,845,502,402,2,813,608,827,307,393,827,212,703,769,427,195,695,740,759,390,697,786,236,177,489,658,209,137,85,466,148,309,559,28,603,766,895,234,960,686,163,442,376,709,325,606,47,73,691,437,266,986,970,171,466,442,142,65,950,62,734,985,418,848,192,58,454,400,270,164,18,340,173,734,1000,677,866,455,176,741,837,603,762,768,450,134,120,309,765,65,222,988,455,383,461,328,970,630,845,747,395,850,544,261,869,290,612,12,853,382,114,548,581,878,469,596,590,773,653,445,126,55,53,14,844,399,363,913,314,742,497,536,192,147,231,662,130,223,10,737,660,380,348,800,60,969,807,220,919,781,458,795,311,441,609,841,455,978,220,582,348,1,549,105,481,205,773,936,739,369,235,978,178,822,312,65,556,259,122,684,398,210,318,738,155,952,345,189,419,819,340,828,367,762,712,387,860,376,750,102,530,898,731,664,204,544,107,892,831,851,335,897,407,851,357,268,305,157,35,185,808,682,120,882,683,561,567,293,344,719,430,986,771,654,173,485,301,193,546,479,141,357,36,957,549,891,168,221,167,75,321,189,615,895,89,452,140,44,417,136,512,540,754,505,589,309,649,302,428,339,980,814,741,122,172,582,236,668,794,643,582,105,663,866,592,495,417,840,746,173,843,930,783,828,661,50,572,896,509,902,54,908,718,576,14,324,554,730,165,372,933,895,951,402,63,469,482,396,520,40,820,403,493,846,710,635,612,333,688,239,56,460,160,76,545,734,748,809,481,370,601,176,583,340,289,374,216,81,647,712,60,581,557,423,480,600,402,265,278,744,72,159,712,998,947,647,980,690,478,105,266,967,784,321,966,937,596,711,758,850,801,702,536,115,621,847,477,754,285,925,814,804,452,569,909,621,327,510,511,678,175,990,408,169,623,878,422,199,161,137,855,543,190,691,483,423,705,474,898,337,832,190,169,811,415,211,259,585,191,628,763,36,951,732,261,833,388,432,333,946,300,487,613,390,884,947,382,648,452,97,420,717,650,897,709,893,932,537,224,385,69,609,678,812,787,506,271,685,673,430,398,998,272,139,451,30,989,110,304,131,286,877,821,117,973,868,142,617,187,326,833,755,334,777,370,330,159,409,32,103,123,724,708,396,48,383,1000,335,920,661,448,260,68,413,744,930,38,151,658,108,415,32,776,480,692,505,946,912,185,271,99,788,889,555,76,379,266,603,84,126,991,545,817,440,903,540,281,721,114,366,613,142,710,238,755,740,514,73,413,771,599,619,604,801,770,441,642,313,143,511,753,448,646,568,403,519,588,601,299,737,631,457,645,263,227,969,949,68,151,418,458,46,159,189,505,764,896,892,373,890,126,165,408,155,310,31,251,993,263,179,467,201,799,462,857,779,511,371,93,728,174,470,18,200,739,60,235,970,474,483,952,14,741,977,909,381,893,94,960,365,314,639,554,541,313,871,227,976,290,167,895,308,737,196,721,302,955,293,848,355,477,43,873,971,258,791,309,970,133,89,467,19,345,374,95,103,498,318,199,430,732,600,923,461,716,279,146,268,606,500,960,530,923,635,880,12,567,665,753,879,387,162,806,447,342,39,589,760,782,702,937,164,16,762,314,913,77,120,889,765,550,430,216,280,887,977,991,635,23,976,638,995,247,706,947,41,67,448,586,7,715,925,295,22,102,235,321,730,863,487,61,377,582,922,492,143,62,421,970,540,153,835,158,936,266,680,65,172,591,811,262,340,978,469,335,78,581,589,987,457,807,606,273,536,96,692,48,720,623,139,824,61,160,966,450,173,287,413,651,850,409,869,463,491,269,315,257,865,357,903,737,226,722,909,594,926,516,761,816,628,20,611,766,660,687,75,427,180,406,108,237,111,504,214,811,205,250,72,396,893,774,135,893,860,266,240,413,606,672,592,389,713,383,161,409,926,930,489,261,929,222,233,745,468,472,345,207,31,303,960,739,743,849,834,743,564,366,573,53,664,892,763,425,106,132,536,482,557,827,123,838,922,726,870,643,457,283,961,707,993,451,309,686,126,174,32,268,367,666,3,445,804,631,262,197,881,894,394,60,734,726,646,109,644,340,817,212,816,857,74,709,145,919,344,814,225,379,219,365,958,397,30,149,820,756,317,991,298,715,497,939,871,918,10,67,663,135,523,1,210,852,784,267,250,644,871,90,705,132,842,428,472,436,671,621,735,460,205,417,790,784,179,282,215,747,624,561,540,749,441,915,92,370,844,612,577,155,226,610,698,509,608,581,756,335,840,659,169,941,896,371,587,723,183,720,463,124,499,876,114,530,494,447,280,831,310,947,182,9,824,432,540,61,216,502,559,936,402,5,208,683,713,993,888,103,111,709,339,542,815,740,73,110,542,454,351,863,314,378,762,413,835,108,179,798,960,511,781,913,28,201,370,825,294,97,828,625,604,415,417,785,934,650,574,38,539,53,930,945,694,114,388,484,914,571,638,552,537,6,469,199,740,390,13,712,169,966,158,375,490,9,181,527,398,866,564,134,591,613,591,910,376,473,547,975,706,470,204,543,805,899,591,899,294,940,464,81,532,175,413,561,679,421,907,45,677,608,192,608,466,171,745,655,382,848,999,257,600,126,701,703,227,535,572,859,648,285,909,549,882,295,19,858,543,107,736,808,374,23,452,77,124,644,517,674,373,902,565,513,331,629,820,438,318,139,429,189,211,377,288,35,30,443,529,597,948,677,343,309,681,937,199,181,677,527,583,489,154,60,367,351,367,672,358,915,513,841,414,87,282,262,594,617,368,568,778,719,871,537,383,184,355,397,637,79,632,987,57,443,216,775,126,937,717,305,659,260,385,791,724,170,585,984,153,702,197,353,830,692,355,16,837,774,260,515,99,729,502,562,362,196,815,246,413,296,249,574,828,713,994,921,239,691,14,257,245,673,541,309,209,268,823,474,377,889,852,26,909,94,615,730,383,878,700,178,433,514,580,545,743,26,69,576,435,809,709,385,280,345,951,217,618,701,129,363,324,73,525,703,754,675,7,369,166,823,315,941,292,629,779,495,55,549,520,729,157,70,268,984,138,681,180,534,899,862,434,135,995,806,706,272,242,497,299,713,697,895,137,126,785,630,840,969,782,269,847,784,450,244,4,68,213,633,892,257,143,822,556,428,177,338,415,381,287,772,157,789,501,347,373,556,949,982,836,861,803,56,703,833,968,158,75,940,86,294,778,282,833,574,805,573,340,53,942,881,665,203,160,334,438,786,458,946,563,477,343,120,768,948,839,823,70,72,130,302,196,355,894,768,993,236,328,810,388,656,58,110,900,397,134,955,74,993,173,231,750,366,484,280,889,385,434,315,606,294,531,552,177,738,546,398,502,299,671,738,223,127,195,764,505,276,310,928,589,481,868,165,223,336,605,808,7,659,95,661,346,770,278,65,332,534,126,514,229,929,15,114,281,31,951,288,408,846,137,601,696,536,588,587,183,800,643,504,977,621,864,94,425,806,630,449,565,967,693,75,819,94,649,761,117,639,905,18,109,599,347,842,89,199,226,466,497,952,8,405,445,444,730,977,750,725,351,338,469,84,499,876,102,651,592,731,217,552,980,308,799,594,514,703,890,526,478,148,382,646,633,460,624,531,115,784,739,954,486,517,134,509,422,646,103,247,165,597,783,843,370,816,845,445,795,942,638,517,475,868,808,239,967,897,55,382,264,942,294,922,622,271,151,550,482,28,812,536,602,74,288,753,816,591,112,18,262,974,92,86,950,80,878,341,804,772,84,687,798,878,62,174,907,878,242,707,82,883,270,544,926,496,717,470,509,399,849,59,704,464,874,487,666,730,89,193,123,221,106,14,782,638,412,278,736,296,295,685,406,480,254,579,281,961,911,907,62,548,840,974,709,712,583,49,954,492,347,377,782,769,645,413,846,993,61,144,961,287,796,702,881,936,681,721,154,58,291,889,552,89,716,546,394,193,20,162,835,138,547,678,414,708,135,622,488,706,528,661,638,273,306,893,567,98,206,776,993,696,744,90,18,954,496,707,682,666,310,424,672,416,497,617,327,273,653,627,764,341,679,983,780,46,72,512,42,233,79,730,507,427,258,212,147,354,187,755,502,625,237,487,461,717,135,45,939,631,228,931,311,67,119,400,569,465,707,38,703,410,61,328,477,389,457,854,106,212,564,893,189,889,248,552,616,816,875,585,710,245,511,189,660,319,614,507,671,704,551,445,492,906,701,781,137,393,742,514,428,947,593,915,300,342,708,705,228,359,537,570,281,436,115,73,245,709,591,822,167,880,54,846,289,15,475,106,78,713,271,646,953,350,865,766,333,337,153,922,743,562,287,582,45,841,346,752,215,246,548,232,46,830,335,64,812,395,632,605,122,914,903,958,326,647,824,507,605,760,313,361,632,642,837,970,604,527,680,264,34,215,756,676,502,592,663,709,85,311,687,608,670,409,271,688,743,421,420,117,55,578,156,635,568,487,174,840,282,207,211,809,19,290,368,829,394,721,738,650,427,196,430,119,936,497,359,105,845,1000,825,116,907,494,348,521,179,870,566,582,530};
        int k = 1957;
        int expected =989332;
        int actual = maxPointFromCards.maxScore(cardPoints, k);
        Assert.assertEquals(expected, actual);
    }
}