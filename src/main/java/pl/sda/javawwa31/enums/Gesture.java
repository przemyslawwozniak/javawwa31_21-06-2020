package pl.sda.javawwa31.enums;

//wg ordinal:
//0 - PAPER
//1 - ROCK
//2 - SCISSORS
public enum Gesture {

    PAPER {
        @Override
        public Result play(Gesture other) {
            switch(other) {
                case ROCK:
                    return Result.WIN;
                case PAPER:
                    return Result.DRAW;
                case SCISSORS:
                    return Result.LOSE;
                default:
                    return Result.DRAW;
            }
        }
    },

    ROCK {
        @Override
        public Result play(Gesture other) {
            switch(other) {
                case ROCK:
                    return Result.DRAW;
                case PAPER:
                    return Result.LOSE;
                case SCISSORS:
                    return Result.WIN;
                default:
                    return Result.DRAW;
            }
            //return Result.DRAW;   //tak tez mozna
        }
    },

    SCISSORS {
        @Override
        public Result play(Gesture other) {
            switch(other) {
                case ROCK:
                    return Result.LOSE;
                case PAPER:
                    return Result.WIN;
                case SCISSORS:
                    return Result.DRAW;
                default:
                    return Result.DRAW;
            }
        }
    };

    public abstract Result play(Gesture other);

}
