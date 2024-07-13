package tgs.vote.common.exception;

public class VoteNotFoundException extends RuntimeException {

    public VoteNotFoundException(Long id) {
        super("Vote not found with id: " + id);
    }

}
